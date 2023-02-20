package com.aquilaeternus.backend.exception;

public class ImageRequestException extends RuntimeException{

    public ImageRequestException(String message) {
        super(message);
    }

    public ImageRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
