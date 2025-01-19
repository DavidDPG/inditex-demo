package com.daviddpg.inditexdemo.service.exception;

public class RateNotFoundException extends ServiceException {
    public RateNotFoundException(String message) {
        super(message);
    }

    public RateNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
