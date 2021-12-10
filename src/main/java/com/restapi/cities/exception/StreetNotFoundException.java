package com.restapi.cities.exception;

public class StreetNotFoundException extends Exception {
    public StreetNotFoundException(String message) {
        super(message);
    }
}
