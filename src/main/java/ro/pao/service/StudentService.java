package ro.pao.service;

import ro.pao.model.Student;

import java.util.List;

public interface StudentService {

    void addStudent(Student student);
    List<Student> getStudents();
}
