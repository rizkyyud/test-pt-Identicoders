package com.test.api.nasa.demo.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.api.nasa.demo.model.Asteroid;

public interface AsteroidRepository extends JpaRepository<Asteroid, Long> {
    List<Asteroid> findByDistanceFromEarthLessThan(double distance);
}
