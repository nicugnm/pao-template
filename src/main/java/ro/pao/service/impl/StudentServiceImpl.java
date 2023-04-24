package ro.pao.service.impl;

import ro.pao.model.Student;
import ro.pao.service.StudentService;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private static List<Student> studentList = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        studentList.add(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentList;
    }
}
