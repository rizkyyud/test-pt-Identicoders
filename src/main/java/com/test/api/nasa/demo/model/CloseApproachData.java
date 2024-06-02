package com.test.api.nasa.demo.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CloseApproachData {
    private String close_approach_date;
    private String close_approach_date_full;
    private long epoch_date_close_approach;
    private RelativeVelocity relative_velocity;
    private MissDistance miss_distance;
    private String orbiting_body;
}
