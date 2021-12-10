package com.restapi.cities.controller;

import com.restapi.cities.exception.CityNotFoundException;
import com.restapi.cities.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public ResponseEntity getCities() {
        try {
            return ResponseEntity.ok().body(cityService.getCities());
        } catch (CityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }
}
