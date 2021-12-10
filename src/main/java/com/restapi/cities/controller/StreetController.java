package com.restapi.cities.controller;

import com.restapi.cities.exception.StreetNotFoundException;
import com.restapi.cities.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/streets")
public class StreetController {

    @Autowired
    private StreetService streetService;

    @GetMapping
    public ResponseEntity getStreets(@RequestParam int city_id) {
        try {
            return ResponseEntity.ok().body(streetService.getStreets(city_id));
        } catch (StreetNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }
}
