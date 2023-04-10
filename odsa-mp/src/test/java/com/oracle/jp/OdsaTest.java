
package com.oracle.jp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import io.helidon.microprofile.tests.junit5.HelidonTest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@HelidonTest
public class OdsaTest {
    private static final Logger logger = Logger.getLogger(OdsaTest.class.getName());

    @PersistenceContext(unitName = "pu1")
    private EntityManager entityManager;

    /**
     * ODSA と言って特別な接続方法とならないことを確認するデモ
     * ref: test/resources/application.yaml
     */
    @Test
    void test_ODSAでプロビジョニングしたATPに接続ができる() {
        var start = System.currentTimeMillis();
        var queryResult = entityManager.createNativeQuery("SELECT * FROM DUAL").getSingleResult();
        logger.info(String.format("Execution Time: %s[ms]", System.currentTimeMillis() - start));
        assertEquals("X", queryResult.toString());
    }

}
