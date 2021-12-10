package com.restapi.cities.controller;

import com.restapi.cities.exception.HouseNotFoundException;
import com.restapi.cities.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/houses")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @GetMapping
    @RequestMapping(params = "street_id")
    public ResponseEntity getHousesByStreetsId(@RequestParam int street_id) {
        try {
            return ResponseEntity.ok().body(houseService.getHousesByStreetId(street_id));
        } catch (HouseNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @GetMapping
    @RequestMapping(params = "city_id")
    public ResponseEntity getHousesByCityId(@RequestParam int city_id) {
        try {
            return ResponseEntity.ok().body(houseService.getHousesByCityId(city_id));
        } catch (HouseNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }
}
