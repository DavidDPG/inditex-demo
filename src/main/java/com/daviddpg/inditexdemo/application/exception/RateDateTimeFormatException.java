package com.daviddpg.inditexdemo.application.exception;

public class RateDateTimeFormatException extends ApplicationException {
    public RateDateTimeFormatException(String message) {
        super(message);
    }

    public RateDateTimeFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
