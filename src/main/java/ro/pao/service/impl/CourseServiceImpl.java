package ro.pao.service.impl;

import ro.pao.model.Course;
import ro.pao.service.CourseService;

import java.util.ArrayList;
import java.util.List;

public class CourseServiceImpl implements CourseService {
    private static List<Course> courseList = new ArrayList<>();
    @Override
    public void addCourse(Course course) {
        courseList.add(course);
    }

    @Override
    public void addCourses(List<Course> courses) {
        courseList.addAll(courses);
    }
}
