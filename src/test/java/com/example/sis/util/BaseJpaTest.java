package com.example.sis.util;

import com.example.sis.model.*;
import com.example.sis.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseJpaTest {
    protected EntityManager em;

    @BeforeEach
    void openEmAndTx() {
        em = JPAUtil.emf().createEntityManager();
        em.getTransaction().begin();
        // Temiz başlangıç (FK sırası önemli)
        em.createQuery("DELETE FROM Enrollment").executeUpdate();
        em.createQuery("DELETE FROM Course").executeUpdate();
        //em.createQuery("DELETE FROM Term").executeUpdate();
        em.createQuery("DELETE FROM Student").executeUpdate();
        em.getTransaction().commit();

        em.getTransaction().begin();
    }

    @AfterEach
    void closeEm() {
        try {
            if (em.getTransaction().isActive()) em.getTransaction().commit();
        } catch (PersistenceException ignore) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    // Küçük yardımcılar
    protected Student newStudent(String n, String s, int year){ return new Student(n, s, year); }
    protected Course  newCourse(String subj, String code, String title, int u){ return new Course(subj, code, title, u); }
    protected Term    newTerm(int y, Season season){ return new Term(y, season); }
}
