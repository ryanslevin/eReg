package com.ryanslevin.ereg.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.ryanslevin.ereg.util.SqlTimeDeserializer;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="courses")
public class Course {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="end_date")
    private Date endDate;

    @Column(name="start_time")
    //@JsonDeserialize(using=SqlTimeDeserializer.class)
    private Time startTime;

    @Column(name="end_time")
    //@JsonDeserialize(using=SqlTimeDeserializer.class)
    @DateTimeFormat()
    private Time endTime;

    @Column(name="location")
    private String location;

    @Column(name="instructor")
    private String instructor;

    public Course() {

    }

    public Course(String name, Date startDate, Date endDate, Time startTime, Time endTime, String location,
            String instructor) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Course [endDate=" + endDate + ", endTime=" + endTime + ", id=" + id + ", instructor=" + instructor
                + ", location=" + location + ", name=" + name + ", startDate=" + startDate + ", startTime=" + startTime
                + "]";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

}