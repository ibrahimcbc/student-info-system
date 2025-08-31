package com.example.sis;

import com.example.sis.model.*;
import com.example.sis.util.JPAUtil;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class StudentPersistenceTest {
    private EntityManager em;

    @BeforeEach
    public void setUp() {
        em = JPAUtil.emf().createEntityManager();
        em.getTransaction().begin();
    }

    @AfterEach
    public void tearDown() {
        if (em.getTransaction().isActive()) em.getTransaction().commit();
        em.close();
    }

    @Test
    public void testStudentPersist() {
        Student s = new Student("Ayşe", "Kaya", 1);
        em.persist(s);
        em.flush();

        Student found = em.find(Student.class, s.getId());
        assertNotNull(found);
        assertEquals("Ayşe", found.getName());
    }
}
