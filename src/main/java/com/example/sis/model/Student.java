package com.example.sis.model;

import jakarta.persistence.*;

@Entity @Table(name="students")
public class Student {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false) private String name;
    @Column(nullable=false) private String surname;

    @Column(name="class_year")
    private Integer classYear;   // kaçıncı sınıf

    public Student() {}
    public Student(String name, String surname, Integer classYear) {
        this.name=name; this.surname=surname; this.classYear=classYear;
    }
}
