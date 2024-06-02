package com.test.api.nasa.demo.model;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NeoFeedResponse {
    private Map<String, NearEarthObject[]> near_earth_objects;
}