package com.aquilaeternus.backend.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

/**
 * This class defines the structure of the data returned when an ApiException occurs.
 */
public class ApiException {
    private final String message;
    private final HttpStatus httpStatus;
    private final int statusCode;
    private final ZonedDateTime timeStamp;

    public ApiException(String message, HttpStatus httpStatus, int statusCode, ZonedDateTime timeStamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.statusCode = statusCode;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }
}
