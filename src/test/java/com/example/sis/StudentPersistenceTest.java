package com.example.sis;

import com.example.sis.model.Student;
import com.example.sis.util.BaseJpaTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class StudentPersistenceTest extends BaseJpaTest {

    @Test
    void testStudentPersist() {
        Student s = new Student("Ayşe", "Kaya", 1);
        em.persist(s);
        em.flush();

        assertNotNull(s.getId());
        Student found = em.find(Student.class, s.getId());
        assertEquals("Ayşe", found.getName());
        assertEquals(1, found.getClassYear());
    }

    @Test
    void update_student() {
        Student s = newStudent("Ali", "Yılmaz", 2);
        em.persist(s);
        em.flush();

        s.setClassYear(3);
        em.flush();

        Student found = em.find(Student.class, s.getId());
        assertEquals(3, found.getClassYear());
    }

    @Test
    void delete_student() {
        Student s = newStudent("Ece", "Demir", 4);
        em.persist(s); em.flush();

        em.remove(s); em.flush();
        assertNull(em.find(Student.class, s.getId()));
    }
}
