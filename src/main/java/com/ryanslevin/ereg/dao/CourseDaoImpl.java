package com.ryanslevin.ereg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.ryanslevin.ereg.entity.Course;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

public class CourseDaoImpl implements CourseDao {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Course> getCourses() {

        //unwrap session
        Session session = entityManager.unwrap(Session.class);

        //query to execute against db
        Query query = session.createQuery("from Courses", Course.class);

        //populate list with data from query
        List<Course> courses = query.getResultList();

        return courses;
    }

    @Override
    @Transactional
    public Course getCourse(int id) {
        
        // Unwrap session from EntityManager
        Session session = entityManager.unwrap(Session.class);

        // Query to execute against the courses db
        Query query = session.createQuery("from Courses where id ="+id, Course.class);

        Course course = (Course) query.getSingleResult();

        return course;

    }

    @Override
    @Transactional
    public void addCourse(Course course) {

        // Unwrap session from EntityManager
        Session session = entityManager.unwrap(Session.class);

        // Save course to db
        session.save(course);

    }

    @Override
    @Transactional
    public void updateCourse(Course course) {

        // Unwrap session from the EntityManager
        Session session = entityManager.unwrap(Session.class);

        // Upodate the course in the db
        session.update(course);

    }

    @Override
    @Transactional
    public void deleteCourse(int id) {

        // Unwrap session from the EntityManager
        Session session = entityManager.unwrap(Session.class);

        // Query to get course from db based on id
        Query query = session.createQuery("from Courses where id ="+id, Course.class);

        // Execute query and assign single result to object
        Course course = (Course) query.getSingleResult();

        // Execute delete action on course
        session.delete(course);

    }
    
}