package com.example.sis.test;

import com.example.sis.model.*;
import com.example.sis.util.BaseJpaTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnrollmentPersistenceTest extends BaseJpaTest {

    @Test
    void testPersistEnrollmentWithStudentAndCourse() {
        Student student = new Student("Ali", "Veli",3);
        Course course = new Course("ENG", "101", "English Literature",3);
        Term term = new Term(2025, Season.FALL);

        em.persist(student);
        em.persist(course);
        em.persist(term);

        Enrollment enrollment = new Enrollment(student, course, term);
        em.persist(enrollment);

        Enrollment found = em.find(Enrollment.class, enrollment.getId());
        assertNotNull(found);
        assertEquals("Ali", found.getStudent().getName());
    }
}
