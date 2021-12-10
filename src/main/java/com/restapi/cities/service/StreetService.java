package com.restapi.cities.service;

import com.restapi.cities.exception.StreetNotFoundException;
import com.restapi.cities.model.StreetModel;
import com.restapi.cities.repo.StreetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetService {

    @Autowired
    private StreetRepo streetRepo;

    public List<StreetModel> getStreets(int cityId) throws StreetNotFoundException {
        if (streetRepo.findStreetsByCityId(cityId) == null) {
            throw new StreetNotFoundException("Улицы не найдены");
        }
        List<StreetModel> streets = StreetModel.toModels(streetRepo.findStreetsByCityId(cityId));
        for (StreetModel street: streets) {
            street.setHouseCounts(getHouseCounts(street.getId()));
        } return streets;
    }

    public Long getHouseCounts(int streetId) throws StreetNotFoundException {
        if (streetRepo.findById(streetId).isEmpty()) {
            throw new StreetNotFoundException("Улицы с таким id не существует");
        } return streetRepo.countHousesByStreetId(streetId);
    }
}
