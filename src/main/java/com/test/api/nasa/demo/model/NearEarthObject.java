package com.test.api.nasa.demo.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NearEarthObject {
    private String name;
    private List<CloseApproachData> close_approach_data;
}
