package com.keyin;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class FlightSystemApplicationTests {

    @Test
    void contextLoads() {
        // This test ensures that the Spring application context loads without errors
        assertTrue(true, "Context loaded successfully");
    }
}
