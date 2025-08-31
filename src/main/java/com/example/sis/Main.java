package com.example.sis;

import com.example.sis.model.*;
import com.example.sis.service.GradeConverter;
import com.example.sis.util.JPAUtil;

import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        var emf = JPAUtil.emf();
        var em  = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Term fall2021 = new Term(2021, Season.FALL);
            em.persist(fall2021);

            Course math106 = new Course("MATH","106","Calculus II",3);
            Course comp100 = new Course("COMP","100","Intro to Computing",3);
            em.persist(math106); em.persist(comp100);

            Student s = new Student("Ali","Yılmaz",2);
            em.persist(s);

            em.persist(new Enrollment(s, math106, fall2021, "A-", GradeConverter.toPoints("A-"), true));
            em.persist(new Enrollment(s, comp100, fall2021, "A",  GradeConverter.toPoints("A"),  true));

            em.getTransaction().commit();
            System.out.println("✓ Örnek veriler kaydedildi.");
        } finally {
            em.close();
            JPAUtil.close();
        }
    }
}
