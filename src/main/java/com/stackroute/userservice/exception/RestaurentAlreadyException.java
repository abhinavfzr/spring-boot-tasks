package com.stackroute.userservice.exception;

public class RestaurentAlreadyException extends Exception {
    private String message;

    public RestaurentAlreadyException() {
    }

    public RestaurentAlreadyException(String message) {
        super(message);
        this.message = message;
    }

}
