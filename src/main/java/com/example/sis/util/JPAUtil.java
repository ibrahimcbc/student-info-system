package com.example.sis.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("sisPU");
    public static EntityManagerFactory emf(){ return emf; }
    public static void close(){ emf.close(); }
}
