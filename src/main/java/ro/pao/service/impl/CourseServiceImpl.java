package ro.pao.service.impl;

import ro.pao.model.Course;
import ro.pao.model.enums.CourseType;
import ro.pao.service.CourseService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CourseServiceImpl implements CourseService {
    private static List<Course> courseList = new ArrayList<>();

    @Override
    public List<Course> getCourses() {
        return courseList;
    }

    @Override
    public void addCourse(Course course) {
        courseList.add(course);
    }

    @Override
    public void addCourses(List<Course> courses) {
        courseList.addAll(courses);
    }

    @Override
    public Optional<Course> getCourseByName(String name) {
        return courseList.stream().filter(course -> course.getName().equals(name)).findFirst();
    }

    @Override
    public Optional<CourseType> getCourseById(UUID id) {
        return courseList.stream().filter(course -> course.getId().equals(id)).findFirst().map(Course::getCourseType);
    }
}
