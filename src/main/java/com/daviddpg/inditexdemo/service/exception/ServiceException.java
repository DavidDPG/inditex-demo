package com.daviddpg.inditexdemo.service.exception;

// I prefer RuntimeExceptions that are caught by an ExceptionHandler
public class ServiceException extends RuntimeException {

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
