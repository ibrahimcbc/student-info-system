package com.example.sis.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity @Table(name="students")
@Data
@NoArgsConstructor
public class Student {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false) private String name;
    @Column(nullable=false) private String surname;

    @Column(name="class_year")
    private Integer classYear;   // kaçıncı sınıf

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Enrollment> enrollments = new ArrayList<>();


    public Student(String name, String surname, Integer classYear) {
        this.name = name;
        this.surname = surname;
        this.classYear = classYear;
    }

}
