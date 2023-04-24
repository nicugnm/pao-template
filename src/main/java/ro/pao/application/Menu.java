package ro.pao.application;

import ro.pao.model.Course;
import ro.pao.model.Student;
import ro.pao.model.abstracts.Person;
import ro.pao.model.enums.CourseType;
import ro.pao.model.enums.DegreeType;
import ro.pao.model.enums.FrequencyType;
import ro.pao.model.enums.PersonType;
import ro.pao.service.CourseService;
import ro.pao.service.PersonService;
import ro.pao.service.StudentService;
import ro.pao.service.impl.CourseServiceImpl;
import ro.pao.service.impl.PersonServiceImpl;
import ro.pao.service.impl.StudentServiceImpl;

import java.util.*;
import java.util.function.Function;
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
    }

    private void menu() {
        Scanner scanner = new Scanner(System.in);
        String menu = """
                
                ----------MENU
                
                0. Exit
                1. Add student
                2. See students
                
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
                default -> System.out.println("Invalid input. Try again.");
            }

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
            System.out.println("Last name: ");
            String lastName = scanner.next();
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
                                     .firstName(firstName)
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