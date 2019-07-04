package com.ryanslevin.ereg.dao;

import java.util.List;

import com.ryanslevin.ereg.entity.Course;

public interface CourseDao {

    public List<Course> getCourses();

    public Course getCourse(int id);

    public void addCourse(Course course);

    public void updateCourse(Course course);

    public void deleteCourse(int id);
}