package com.oracle.jp.odsa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.helidon.microprofile.tests.junit5.HelidonTest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@HelidonTest
public class OdsaTest {

    @PersistenceContext(unitName = "pu1")
    private EntityManager entityManager;

    @Test
    void testConnection() {
        var result = entityManager.createNativeQuery("SELECT * FROM DUAL").getSingleResult();
        assertEquals("X", result.toString());
    }

}
