package ro.pao.service;

import ro.pao.model.Course;

import java.util.List;

public interface CourseService {
    void addCourse(Course course);
    void addCourses(List<Course> courses);
}
