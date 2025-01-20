package com.daviddpg.inditexdemo.application.handler;

import com.daviddpg.inditexdemo.application.exception.RateDateTimeFormatException;
import com.daviddpg.inditexdemo.service.exception.RateNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class RateExceptionHandler {

    @ResponseBody
    @ExceptionHandler(RateNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(RateNotFoundException rateNotFoundException) {
        log.error(rateNotFoundException.getMessage(), rateNotFoundException);
        return ErrorDTO.builder()
                .code(HttpStatus.NOT_FOUND.toString())
                .message(rateNotFoundException.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(RateDateTimeFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO handleException(RateDateTimeFormatException rateDateTimeFormatException) {
        log.error(rateDateTimeFormatException.getMessage(), rateDateTimeFormatException);
        return ErrorDTO.builder()
                .code(HttpStatus.BAD_REQUEST.toString())
                .message(rateDateTimeFormatException.getMessage())
                .build();
    }


}
