package com.schh.runnerz.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(Integer id,
                  @NotEmpty
                  String title,
                  LocalDateTime startedOn,
                  @NotNull
                  LocalDateTime completedOn,
                  @Positive
                  Integer miles,
                  Location location) {

    public Run {
        if(!completedOn.isAfter(startedOn)){
            throw new IllegalArgumentException("Completed On must be after started on");
        }
    }
}
