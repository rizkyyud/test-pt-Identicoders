package com.test.api.nasa.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.test.api.nasa.demo.model.Asteroid;
import com.test.api.nasa.demo.model.CloseApproachData;
import com.test.api.nasa.demo.model.NearEarthObject;
import com.test.api.nasa.demo.model.NeoFeedResponse;
import com.test.api.nasa.demo.model.repository.AsteroidRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AsteroidService {
    @Value("${nasa.api.key}")
    private String apiKey;

    @Value("${nasa.api.url}")
    private String apiUrl;

    @Autowired
    private AsteroidRepository asteroidRepository;

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Asteroid> getTop10ClosestAsteroids(String startDate, String endDate) {
        String url = String.format("%s?start_date=%s&end_date=%s&api_key=%s", apiUrl, startDate, endDate, apiKey);
        NeoFeedResponse response = restTemplate.getForObject(url, NeoFeedResponse.class);

        if (response == null || response.getNear_earth_objects() == null) {
            throw new RuntimeException("Failed to retrieve data from NASA API");
        }

        List<Asteroid> allAsteroids = new ArrayList<>();

        for (Map.Entry<String, NearEarthObject[]> entry : response.getNear_earth_objects().entrySet()) {
            for (NearEarthObject neo : entry.getValue()) {
                for (CloseApproachData cad : neo.getClose_approach_data()) {
                    Asteroid asteroid = new Asteroid(
                            neo.getName(),
                            Double.parseDouble(cad.getMiss_distance().getKilometers()),
                            cad.getClose_approach_date());
                    allAsteroids.add(asteroid);
                }
            }
        }

        List<Asteroid> top10Asteroids = allAsteroids.stream()
                .sorted(Comparator.comparingDouble(Asteroid::getDistanceFromEarth))
                .limit(10)
                .collect(Collectors.toList());

        asteroidRepository.saveAll(top10Asteroids); // Save top 10 asteroids to the database

        return top10Asteroids;
    }

    public List<Asteroid> searchAsteroidsByDistance(double distance) {
        return asteroidRepository.findByDistanceFromEarthLessThan(distance);
    }

}
