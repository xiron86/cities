package com.restapi.cities.exception;

public class CityNotFoundException extends Exception {
    public CityNotFoundException(String message) {
        super(message);
    }
}
