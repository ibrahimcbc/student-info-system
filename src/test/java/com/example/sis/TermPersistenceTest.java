package com.example.sis.test;

import com.example.sis.model.Season;
import com.example.sis.model.Term;
import com.example.sis.util.BaseJpaTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TermPersistenceTest extends BaseJpaTest {

    @Test
    void testPersistAndFindTerm() {
        Term term = new Term(2025, Season.FALL);
        em.persist(term);

        Term found = em.find(Term.class, term.getId());
        assertNotNull(found);
        assertEquals(Season.FALL, found.getSeason());
    }

    @Test
    void testRemoveTerm() {
        Term term = new Term(2025, Season.FALL);
        em.persist(term);
        Long id = term.getId();

        em.remove(term);
        em.flush();

        Term deleted = em.find(Term.class, id);
        assertNull(deleted);
    }
}
