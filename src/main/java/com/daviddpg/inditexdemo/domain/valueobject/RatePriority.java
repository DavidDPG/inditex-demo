package com.daviddpg.inditexdemo.domain.valueobject;

public record RatePriority(Integer priority) implements Comparable<RatePriority> {
    @Override
    public int compareTo(RatePriority o) {
        return Integer.compare(this.priority, o.priority);
    }
}
