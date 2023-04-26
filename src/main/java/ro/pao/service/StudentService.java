package ro.pao.service;

import ro.pao.model.records.CourseData;
import ro.pao.model.Student;

import java.util.List;
import java.util.UUID;

public interface StudentService {

    void addStudent(Student student);
    void addStudents(List<Student> student);
    void addCourseToStudent(Student student, UUID courseId);
    List<Student> getStudents();
    String getReversedFirstname(UUID studentId);
    CourseData getCourseData();
}
