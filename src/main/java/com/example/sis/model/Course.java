package com.example.sis.model;

import jakarta.persistence.*;

@Entity
@Table(name="courses",
        uniqueConstraints=@UniqueConstraint(columnNames={"course_subject","course_code"}))
public class Course {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="course_subject", nullable=false, length=16) // "MATH","COMP"
    private String courseSubject;

    @Column(name="course_code", nullable=false, length=16)    // "106","100"
    private String courseCode;

    @Column(nullable=false)
    private String title;       // "Calculus II"

    @Column(nullable=false)
    private Integer units;      // 3

    public Course() {}
    public Course(String subject, String code, String title, Integer units) {
        this.courseSubject = subject; this.courseCode = code;
        this.title = title; this.units = units;
    }

    @Transient
    public String getDisplayCode(){ return courseSubject + " " + courseCode; }
}
