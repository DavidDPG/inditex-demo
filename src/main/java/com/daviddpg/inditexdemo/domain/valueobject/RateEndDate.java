package com.daviddpg.inditexdemo.domain.valueobject;

import java.time.LocalDateTime;

public record RateEndDate(LocalDateTime endDate) {

    public boolean isSameOrAfterThan(LocalDateTime otherDateTime) {
        // I use negation because there is no LocalDateTime#isSameOrBefore
        return !endDate.isBefore(otherDateTime);
    }
}
