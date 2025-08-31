package com.example.sis.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="enrollments",
        uniqueConstraints=@UniqueConstraint(columnNames={"student_id","course_id","term_id"}))
public class Enrollment {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="student_id", nullable=false)
    private Student student;

    @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="course_id", nullable=false)
    private Course course;

    @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="term_id", nullable=false)
    private Term term;

    @Column(name="letter_grade", length=3)     // "A","A-","B+"...
    private String letterGrade;

    @Column(name="numeric_grade", precision=3, scale=2) // 3.70 gibi
    private BigDecimal numericGrade;

    @Column(name="included_in_gpa", nullable=false)
    private Boolean includedInGpa = Boolean.TRUE;

    public Enrollment() {}
    public Enrollment(Student s, Course c, Term t, String lg, BigDecimal ng, boolean inc){
        this.student=s; this.course=c; this.term=t;
        this.letterGrade=lg; this.numericGrade=ng; this.includedInGpa=inc;
    }
}
