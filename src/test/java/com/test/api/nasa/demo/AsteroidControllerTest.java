package com.test.api.nasa.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.test.api.nasa.demo.controllers.AsteroidController;
import com.test.api.nasa.demo.model.Asteroid;
import com.test.api.nasa.demo.services.AsteroidService;

public class AsteroidControllerTest {
    @InjectMocks
    private AsteroidController asteroidController;

    @Mock
    private AsteroidService asteroidService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetTop10ClosestAsteroids() {
        String startDate = "2024-06-01";
        String endDate = "2024-06-02";
        List<Asteroid> asteroids = Arrays.asList(
                new Asteroid("Asteroid1", 50000, "2024-06-01"),
                new Asteroid("Asteroid2", 80000, "2024-06-02"));
        when(asteroidService.getTop10ClosestAsteroids(startDate, endDate)).thenReturn(asteroids);

        List<Asteroid> result = asteroidController.getTop10ClosestAsteroids(startDate, endDate);
        assertEquals(2, result.size());
        assertEquals("Asteroid1", result.get(0).getName());
        assertEquals("Asteroid2", result.get(1).getName());
    }

    @Test
    void testSearchAsteroidsByDistance() {
        double distance = 100000;
        List<Asteroid> asteroids = Arrays.asList(
                new Asteroid("Asteroid1", 50000, "2024-06-01"),
                new Asteroid("Asteroid2", 80000, "2024-06-02"));
        when(asteroidService.searchAsteroidsByDistance(distance)).thenReturn(asteroids);
        List<Asteroid> result = asteroidController.searchAsteroidsByDistance(distance);

        // Verifying results
        assertEquals(2, result.size());
        assertEquals("Asteroid1", result.get(0).getName());
        assertEquals("Asteroid2", result.get(1).getName());
    }
}
