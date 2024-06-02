package com.test.api.nasa.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.api.nasa.demo.model.Asteroid;
import com.test.api.nasa.demo.services.AsteroidService;

@RestController
@RequestMapping("api/testing/asteroid")
public class AsteroidController {

    @Autowired
    private AsteroidService asteroidService;

    @GetMapping("/top10")
    public List<Asteroid> getTop10ClosestAsteroids(@RequestParam String startDate, @RequestParam String endDate) {
        return asteroidService.getTop10ClosestAsteroids(startDate, endDate);
    }

    @GetMapping("/getByDistence")
    public List<Asteroid> searchAsteroidsByDistance(@RequestParam double distance) {
        return asteroidService.searchAsteroidsByDistance(distance);
    }
}
