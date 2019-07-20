package com.ryanslevin.ereg.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ryanslevin.ereg.entity.Course;
import com.ryanslevin.ereg.entity.User;

@Entity
@Table(name="registrations")
public class Registration {

    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User user;

    @ManyToOne(targetEntity = Course.class)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    Course course;

    @Column(name="registered_date_time", nullable = false)
    Date dateTime;

    @Column(name="cancelled", nullable = false)
    boolean cancelled;

    @Column(name="cancelled_date_time")
    Date cancelledDateTime;

    public Registration() {
        
    }

    public Registration(User user, Course course) {
        this.user = user;
        this.course = course;
        this.dateTime = new Date();
        this.cancelled = false;
        this.cancelledDateTime = null;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public Date getCancelledDateTime() {
        return cancelledDateTime;
    }

    public void setCancelledDateTime(Date cancelledDateTime) {
        this.cancelledDateTime = cancelledDateTime;
    }
    
}