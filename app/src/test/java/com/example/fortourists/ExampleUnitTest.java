package com.example.fortourists;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void attraction_getters() {
        Attraction attraction = new Attraction("Test Attraction", "Test Description", 1.0, 2.0);

        assertEquals("Test Attraction", attraction.getName());
        assertEquals("Test Description", attraction.getDescription());
        assertEquals(1.0, attraction.getLatitude(), 0.001);
        assertEquals(2.0, attraction.getLongitude(), 0.001);
    }
}
