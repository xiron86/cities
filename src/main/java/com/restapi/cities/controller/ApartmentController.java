package com.restapi.cities.controller;

import com.restapi.cities.exception.ApartmentNotFoundException;
import com.restapi.cities.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apartments")
public class ApartmentController {

    @Autowired
    ApartmentService apartmentService;

    @GetMapping
    public ResponseEntity getApartment(int id) {
        try {
            return ResponseEntity.ok().body(apartmentService.getApartment(id));
        } catch (ApartmentNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }
}
