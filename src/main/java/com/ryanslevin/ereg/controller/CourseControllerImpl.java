package com.ryanslevin.ereg.controller;

import java.util.List;

import com.ryanslevin.ereg.entity.Course;
import com.ryanslevin.ereg.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class CourseControllerImpl implements CourseController {

    @Autowired
    CourseService courseService;

    // API endpoint that returns all coures
    // Endpoint: http://localhost:8080/api/courses
    @Override
    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

    // API endpoint that returns course where id = n
    // Endpoint: http://localhost:8080/api/course?id=n
    @Override
    @GetMapping("/course")
    public Course getCourse(@RequestParam int id) {
        System.out.println(courseService.getCourse(id));
        return courseService.getCourse(id);
    }


    // API endpoint that adds a course to the db
    // Endpoint: http://localhost:8080/api/course
    @Override
    @PostMapping("/course")
    public void addCourse(@RequestBody Course course) {
        courseService.addCourse(course);

    }

    // API endpoint that updates a course in the db where course in db = course param
    // Endpoint: http://localhost:8080/api/course    
    @Override
    @PutMapping("/course")
    public void updateCourse(@RequestBody Course course) {
        courseService.updateCourse(course);

    }

    // API endpoint that deletes a user in the db where id = n
    // Endpoint: http://localhost:8080/api/course?id=n    
    @Override
    @DeleteMapping("/course")
    public void deleteCourse(@RequestParam int id) {
        courseService.deleteCourse(id);

    }
    
}