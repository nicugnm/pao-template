package ro.pao.service.impl;

import ro.pao.application.MyCollectorsClass;
import ro.pao.model.Student;
import ro.pao.model.enums.CourseType;
import ro.pao.model.records.CourseData;
import ro.pao.service.CourseService;
import ro.pao.service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {
    private static List<Student> studentList = new ArrayList<>();
    private static CourseService courseService = new CourseServiceImpl();

    @Override
    public void addStudent(Student student) {
        studentList.add(student);
    }

    @Override
    public void addStudents(List<Student> student) {
        studentList.addAll(student);
    }

    @Override
    public void addCourseToStudent(Student student, UUID courseId) {
        student.getCourses().add(courseId);
    }

    @Override
    public List<Student> getStudents() {
        return studentList;
    }

    @Override
    public CourseData getCourseData() {
        Predicate<Student> hasMandatoryCourse = s -> s.getCourses().stream().anyMatch(c -> courseService.getCourseById(c).get().equals(CourseType.MANDATORY));
        Predicate<Student> hasFacultativeCourse = s -> s.getCourses().stream().anyMatch(c -> courseService.getCourseById(c).get().equals(CourseType.FACULTATIVE));
        Predicate<Student> hasOptionalCourse = s -> s.getCourses().stream().anyMatch(c -> courseService.getCourseById(c).get().equals(CourseType.OPTIONAL));
        CourseData courseData = studentList.stream()
                .collect(MyCollectorsClass.teeing(
                        Collectors.filtering(hasMandatoryCourse, Collectors.toList()),
                        Collectors.filtering(hasFacultativeCourse, Collectors.toList()),
                        Collectors.filtering(hasOptionalCourse, Collectors.toList()),
                        CourseData::new
                                                 )
                        );
        return courseData;
    }
}
