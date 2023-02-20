package com.aquilaeternus.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ImageExceptionHandler {
    @ExceptionHandler(value = {ImageRequestException.class})
    public ResponseEntity<Object> handleImageRequestException(ImageRequestException e) {
        final int INTERNAL_ERROR_CODE = 500;
        ApiException apiException = new ApiException(
                e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                INTERNAL_ERROR_CODE,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        return new ResponseEntity<>(apiException, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
