package com.example.sis.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
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
    private Integer credits;      // 3

    @Transient
    public String getDisplayCode(){ return courseSubject + " " + courseCode; }

    public Course(String courseSubject, String courseCode, String title, Integer credits) {
        this.courseSubject = courseSubject;
        this.courseCode = courseCode;
        this.title = title;
        this.credits = credits;
    }
}
