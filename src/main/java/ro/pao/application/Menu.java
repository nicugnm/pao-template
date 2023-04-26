package ro.pao.application;

import ro.pao.model.Course;
import ro.pao.model.Professor;
import ro.pao.model.Student;
import ro.pao.model.enums.CourseType;
import ro.pao.model.enums.DegreeType;
import ro.pao.model.enums.FrequencyType;
import ro.pao.model.enums.PersonType;
import ro.pao.model.records.CourseData;
import ro.pao.service.CourseService;
import ro.pao.service.PersonService;
import ro.pao.service.ProfessorService;
import ro.pao.service.StudentService;
import ro.pao.service.impl.CourseServiceImpl;
import ro.pao.service.impl.PersonServiceImpl;
import ro.pao.service.impl.ProfessorServiceImpl;
import ro.pao.service.impl.StudentServiceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.function.Predicate;

/**
 * In Meniu se fac operatiile care pot lua informatii din toate dintre servicile definite.
 * De exemplu, avem definit mai jos `private final ExampleService exampleService = new ExampleServiceImpl();`
 *
 * In cazul in care aveam definit mai multe servicii, la fel, faceam o initializare a serviciile si astfel apelam metode din serviciu.
 */
public class Menu {

    private static Menu INSTANCE;

    private static Scanner scanner = new Scanner(System.in);
    private static PersonService personService = new PersonServiceImpl();
    private static CourseService courseService = new CourseServiceImpl();
    private static ProfessorService professorService = new ProfessorServiceImpl();
    private static StudentService studentService = new StudentServiceImpl();
    private Predicate<PersonService> canAccess = ps -> ps.getCurrentUserType().equals(personService.getRequiredUser());

    public static Menu getInstance() {
        return (INSTANCE == null ? new Menu() : INSTANCE);
    }

    public void intro() {
        Scanner scanner = new Scanner(System.in);
        String intro = """
                
                ----------MINI CLASS REGISTER
                
                """;

        System.out.println(intro);

        while (true) {
            String request = "Choose type of user(1-Student, 2-Professor, 3-Secretary): ";
            System.out.println(request);
            String option = scanner.next();
            if ("1".equals(option)) {
                personService.setCurrentUser(PersonType.STUDENT);
                break;
            } else if ("2".equals(option)) {
                personService.setCurrentUser(PersonType.PROFESSOR);
                break;
            } else if("3".equals(option)) {
                personService.setCurrentUser(PersonType.SECRETARY);
                break;
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }
        populate();
        menu();
    }

    private void populate() {
        courseService.addCourses(List.of(
                Course.builder()
                        .name("Mathematics")
                        .courseType(CourseType.FACULTATIVE)
                        .build(),
                Course.builder()
                        .name("English")
                        .courseType(CourseType.FACULTATIVE)
                        .build(),
                Course.builder()
                        .name("OOP")
                        .courseType(CourseType.MANDATORY)
                        .build(),
                Course.builder()
                        .name("Algebra")
                        .courseType(CourseType.MANDATORY)
                        .build(),
                Course.builder()
                        .name("Geometry")
                        .courseType(CourseType.MANDATORY)
                        .build(),
                Course.builder()
                        .name("Physics")
                        .courseType(CourseType.OPTIONAL)
                        .build()
                                        ));
        List<Student> students = List.of(
                Student.builder()
                        .firstName(List.of("John"))
                        .lastName("Doe")
                        .degree(DegreeType.BACHELOR)
                        .frequency(FrequencyType.ID)
                        .build(),
                Student.builder()
                        .firstName(List.of("Jane"))
                        .lastName("Doe")
                        .degree(DegreeType.BACHELOR)
                        .frequency(FrequencyType.IF)
                        .build(),
                Student.builder()
                        .firstName(List.of("John"))
                        .lastName("Smith")
                        .degree(DegreeType.MASTER)
                        .frequency(FrequencyType.ID)
                        .build()
                                          );
        studentService.addStudents(students);
        studentService.addCourseToStudent(students.get(0), courseService.getCourseByName("Mathematics").get().getId());
        studentService.addCourseToStudent(students.get(0), courseService.getCourseByName("English").get().getId());
        studentService.addCourseToStudent(students.get(0), courseService.getCourseByName("OOP").get().getId());
        studentService.addCourseToStudent(students.get(0), courseService.getCourseByName("Algebra").get().getId());
        studentService.addCourseToStudent(students.get(0), courseService.getCourseByName("Geometry").get().getId());
        studentService.addCourseToStudent(students.get(0), courseService.getCourseByName("Physics").get().getId());
        studentService.addCourseToStudent(students.get(1), courseService.getCourseByName("Mathematics").get().getId());
        studentService.addCourseToStudent(students.get(1), courseService.getCourseByName("English").get().getId());
        studentService.addCourseToStudent(students.get(2), courseService.getCourseByName("OOP").get().getId());
    }

    private void menu() {
        Scanner scanner = new Scanner(System.in);
        String menu = """
                
                ----------MENU
                
                0. Exit
                1. Add student
                2. See students
                3. See students by type of course they attend
                4. Enroll student to course
                5. Add teacher
                
                """;

        System.out.println(menu);
        boolean flag = true;
        while (flag) {
            String request = "Choose an option: ";
            System.out.println(request);
            switch (scanner.next()) {
                case "0" -> flag = false;
                case "1" -> addStudent();
                case "2" -> seeStudents();
                case "3" -> seeStudentsByTypeOfCourse();
                case "4" -> enrollStudentToCourse();
                case "5" -> addProfessor();
                default -> System.out.println("Invalid input. Try again.");
            }

        }
    }

    private void addProfessor() {
        personService.setRequiredUser(PersonType.SECRETARY);
        if (canAccess.test(personService)) {
            System.out.println("    Add professor");
            System.out.println("First name: ");
            String firstName = scanner.next();
            while(Character.isLowerCase(firstName.charAt(0))) {
                System.out.println("Invalid input. Try again.");
                firstName = scanner.next();
            }
            List<String> listFirstName = Arrays.stream(firstName.split("-")).toList();
            System.out.println("Last name: ");
            String lastName = scanner.next();
            while(Character.isLowerCase(lastName.charAt(0))) {
                System.out.println("Invalid input. Try again.");
                lastName = scanner.next();
            }
            System.out.println("Birth date(yyyy-MM-dd): ");
            String birthDate = scanner.next();
            System.out.println("Birth hour(HH:mm): ");
            String birthHour = scanner.next();
            String allBirthDate = birthDate + " " + birthHour;
            boolean flag = false;
            LocalDateTime dateTime = null;
            while(!flag) {
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    dateTime = LocalDateTime.parse(allBirthDate, formatter);
                    flag = true;
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid input. Try again.");
                    birthDate = scanner.next();
                }
            }
            System.out.println("Birth place: ");
            String birthPlace = scanner.next();
            System.out.println("Email: ");
            String email = scanner.next();
            Professor professor = Professor.builder()
                    .firstName(listFirstName)
                    .lastName(lastName)
                    .birthDate(dateTime)
                    .birthPlace(birthPlace)
                    .email(email)
                    .build();

            professorService.addProfessor(professor);
        } else {
            System.out.println("You don't have access to this option.");
        }
    }

    private void enrollStudentToCourse() {
        personService.setRequiredUser(PersonType.SECRETARY);
        if (canAccess.test(personService)) {
            System.out.println("    Enroll student to course");
            List<Student> students = studentService.getStudents();
            System.out.println("        Choose student:");
            for (int i = 0; i < students.size(); i++) {
                System.out.println("            " + i + ". " + students.get(i).getFirstName() + " " + students.get(i).getLastName());
            }
            System.out.println("        Enter student index: ");
            int studentIndex = scanner.nextInt();
            Student student = students.get(studentIndex);
            List<Course> courses = courseService.getCourses();
            System.out.println("        Choose course:");
            for (int i = 0; i < courses.size(); i++) {
                System.out.println("            " + (i + 1) + ". " + courses.get(i).getName());
            }
            System.out.println("        Enter course index: ");
            int courseIndex = scanner.nextInt();
            Course course = courses.get(courseIndex);
            try {
                studentService.addCourseToStudent(student, course.getId());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("You don't have access to this option.");
        }
    }

    private void seeStudentsByTypeOfCourse() {
        personService.setRequiredUser(PersonType.SECRETARY);
        if (canAccess.test(personService)) {
            CourseData courseData = studentService.getCourseData();
            System.out.println("    Students by type of course they attend:");
            System.out.println("        Mandatory:");
            courseData.mandatories().forEach(System.out::println);
            System.out.println("        Optional:");
            courseData.optionals().forEach(System.out::println);
            System.out.println("        Facultative:");
            courseData.facultatives().forEach(System.out::println);
        } else {
            System.out.println("You don't have access to this option.");
        }
    }

    private void seeStudents() {
        personService.setRequiredUser(PersonType.SECRETARY);
        if (canAccess.test(personService)) {
            System.out.println("    All students:");
            studentService.getStudents().forEach(System.out::println);
        } else {
            System.out.println("You don't have access to this option.");
        }
    }

    private void addStudent() {
        personService.setRequiredUser(PersonType.SECRETARY);
        if (canAccess.test(personService)) {
            System.out.println("    Add student:");
            System.out.println("First name: ");
            String firstName = scanner.next();
            while(Character.isLowerCase(firstName.charAt(0))) {
                System.out.println("Invalid input. Try again.");
                firstName = scanner.next();
            }
            List<String> listFirstName = Arrays.stream(firstName.split("-")).toList();
            System.out.println("Last name: ");
            String lastName = scanner.next();
            while(Character.isLowerCase(lastName.charAt(0))) {
                System.out.println("Invalid input. Try again.");
                lastName = scanner.next();
            }
            System.out.println("Degree(Bachelor/Master/PhD): ");
            DegreeType degreeType = DegreeType.getByType(scanner.next());
            while(degreeType == null) {
                System.out.println("Invalid input. Try again.");
                degreeType = DegreeType.getByType(scanner.next());
            }
            System.out.println("Frequency(IF/ID): ");
            FrequencyType frequencyType = FrequencyType.getByType(scanner.next());
            while(frequencyType == null) {
                System.out.println("Invalid input. Try again.");
                frequencyType = FrequencyType.getByType(scanner.next());
            }
            Student student = Student.builder()
                                     .firstName(listFirstName)
                                     .lastName(lastName)
                                     .personType(PersonType.STUDENT)
                                     .degree(degreeType)
                                     .frequency(frequencyType)
                                     .build();
            studentService.addStudent(student);
        } else {
            System.out.println("You don't have access to this option.");
        }
    }
}