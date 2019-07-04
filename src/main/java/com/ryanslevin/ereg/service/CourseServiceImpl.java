package com.ryanslevin.ereg.service;

import java.util.List;

import com.ryanslevin.ereg.entity.Course;

import org.springframework.beans.factory.annotation.Autowired;

public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseDao courseDao;

    @Override
    public List<Course> getCourses() {
        return courseDao.getCourses();
    }

    @Override
    public Course getCourse(int id) {
        return courseDao.getCourse(id);
    }

    @Override
    public void addCourse(Course course) {
        courseDao.addCourse(course);

    }

    @Override
    public void updateCourse(Course course) {
        courseDao.updateCourse(course);

    }

    @Override
    public void deleteCourse(int id) {
        courseDao.deleteCourse(id);

    }

}