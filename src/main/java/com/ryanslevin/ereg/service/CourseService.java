package com.ryanslevin.ereg.service;

import java.util.List;

import com.ryanslevin.ereg.entity.Course;

public interface CourseService {

    public List<Course> getCourses();

    public Course getCourse(int id);

    public void addCourse(Course course);

    public void updateCourse(Course course);

    public void deleteCourse(int id);

}