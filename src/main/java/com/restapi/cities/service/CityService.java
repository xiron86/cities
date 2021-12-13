package com.restapi.cities.service;

import com.restapi.cities.exception.CityNotFoundException;
import com.restapi.cities.repo.CityRepo;
import com.restapi.cities.model.CityModel;
import com.restapi.cities.repo.HouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepo cityRepo;

    @Autowired
    private HouseRepo houseRepo;

    public List<CityModel> getCities() throws CityNotFoundException {
        if (cityRepo.findAll().isEmpty()) {
            throw new CityNotFoundException("Города не найдены");
        }
        List<CityModel> cities = CityModel.toModels(cityRepo.findAll());
        for (CityModel city: cities) {
            city.setHouseCounts(getHouseCounts(city.getId()));
        } return cities;
    }

    public Long getHouseCounts(int cityId) throws CityNotFoundException {
        if (cityRepo.findById(cityId).isEmpty()) {
            throw new CityNotFoundException("Города с id=" + cityId + " не существует");
        } return cityRepo.countHousesByCityId(cityId);
    }

    public CityModel getCity(int id) throws CityNotFoundException {
        if (cityRepo.findById(id).isEmpty()) {
            throw new CityNotFoundException("Город с id=" + id + " не найден");
        } return CityModel.toModel(cityRepo.findById(id).get());
    }
}
