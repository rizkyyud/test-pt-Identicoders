package com.test.api.nasa.demo.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RelativeVelocity {
    private String kilometers_per_second;
    private String kilometers_per_hour;
    private String miles_per_hour;
}
