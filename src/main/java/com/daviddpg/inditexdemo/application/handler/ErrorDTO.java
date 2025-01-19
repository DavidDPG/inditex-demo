package com.daviddpg.inditexdemo.application.handler;

import lombok.Builder;

@Builder
public record ErrorDTO(String code, String message) {
}
