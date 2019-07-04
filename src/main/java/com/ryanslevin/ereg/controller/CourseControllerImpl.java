package com.ryanslevin.ereg.controller;

import java.util.List;

import com.ryanslevin.ereg.entity.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public class CourseControllerImpl implements CourseController {

    @Autowired
    CourseService courseService;

    @Override
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

    @Override
    public Course getCourse(@RequestParam int id) {
        return courseService.getCourse(id);
    }

    @Override
    public void addCourse(@RequestBody Course course) {
        courseService.addCourse(course);

    }

    @Override
    public void updateCourse(@RequestBody Course course) {
        courseService.updateCourse(course);

    }

    @Override
    public void deleteCourse(@RequestParam int id) {
        courseService.deleteCourse(id);

    }
    
}