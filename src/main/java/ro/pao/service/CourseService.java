package ro.pao.service;

import ro.pao.model.Course;
import ro.pao.model.enums.CourseType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseService {
    List<Course> getCourses();
    void addCourse(Course course);
    void addCourses(List<Course> courses);
    Optional<Course> getCourseByName(String name);
    Optional<CourseType> getCourseById(UUID id);
}
