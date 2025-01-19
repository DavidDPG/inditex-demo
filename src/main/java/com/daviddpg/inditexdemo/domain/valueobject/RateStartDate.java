package com.daviddpg.inditexdemo.domain.valueobject;

import java.time.LocalDateTime;

public record RateStartDate(LocalDateTime startDate) {
    public boolean isSameOrBeforeThan(LocalDateTime otherDateTime) {
        // I use negation because there is no LocalDateTime#isSameOrAfter
        return !startDate.isAfter(otherDateTime);
    }
}
