package com.test.api.nasa.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Asteroid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double distanceFromEarth;
    private String closeApproachDate;

    public Asteroid() {
    }

    public Asteroid(String name, double distanceFromEarth, String closeApproachDate) {
        this.name = name;
        this.distanceFromEarth = distanceFromEarth;
        this.closeApproachDate = closeApproachDate;
    }
}
