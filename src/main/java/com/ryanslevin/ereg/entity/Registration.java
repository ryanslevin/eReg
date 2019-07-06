package com.ryanslevin.ereg.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="registrations")
public class Registration {

    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="user_id", nullable = false)
    User user;

    @Column(name="course_id", nullable = false)
    Course course;

    @Column(name="date_time", nullable = false)
    Date dateTime;

    @Column(name="cancelled", nullable = false)
    boolean cancelled;

    @Column(name="cancelled_date_time")
    Date cancelledDateTime;

    public Registration(User user, Course course, Date dateTime, boolean cancelled, Date cancelledDateTime) {
        this.user = user;
        this.course = course;
        this.dateTime = dateTime;
        this.cancelled = cancelled;
        this.cancelledDateTime = cancelledDateTime;
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