package com.example.sis.test;

import com.example.sis.model.Course;
import com.example.sis.util.BaseJpaTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CoursePersistenceTest extends BaseJpaTest {

    @Test
    void testPersistAndFindCourse() {
        Course course = new Course("CS", "101", "Intro to Programming",3);
        em.persist(course);

        Course found = em.find(Course.class, course.getId());
        assertNotNull(found);
        assertEquals("Intro to Programming", found.getTitle());
    }

    @Test
    void testRemoveCourse() {
        Course course = new Course("MATH", "106", "Calculus",3);
        em.persist(course);
        Long id = course.getId();

        em.remove(course);
        em.flush();  // remove işlemini hemen uygula

        Course deleted = em.find(Course.class, id);
        assertNull(deleted);
    }
}
