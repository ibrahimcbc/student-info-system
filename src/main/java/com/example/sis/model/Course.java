package com.example.sis.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @Transient
    public String getDisplayCode(){ return courseSubject + " " + courseCode; }
}
