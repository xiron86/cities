package com.restapi.cities.service;

import com.restapi.cities.exception.HouseNotFoundException;
import com.restapi.cities.model.HouseModel;
import com.restapi.cities.repo.HouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {

    @Autowired
    private HouseRepo houseRepo;

    public List<HouseModel> getHousesByStreetId(int streetId) throws HouseNotFoundException {
        if (houseRepo.findHousesByStreetId(streetId) == null) {
            throw new HouseNotFoundException("Дома на улице с id=" + streetId + " не найдены");
        }
        List<HouseModel> houses = HouseModel.toModels(houseRepo.findHousesByStreetId(streetId));
        for (HouseModel house: houses) {
            house.setApartmentCounts(getApartmentCountsByStreetId(house.getId()));
            house.setAddress(getHouseAddress(house.getId()));
        } return houses;
    }

    public Long getApartmentCountsByStreetId(int streetId) throws HouseNotFoundException {
        if (houseRepo.findById(streetId).isEmpty()) {
            throw new HouseNotFoundException("Дома на улице с id=" + streetId + " не найдены");
        } return houseRepo.countApartmentsByStreetId(streetId);
    }

    public List<HouseModel> getHousesByCityId(int cityId) throws HouseNotFoundException {
        if (houseRepo.findHousesByCityId(cityId) == null) {
            throw new HouseNotFoundException("Дома в городе с id=" + cityId + " не найдены");
        }
        List<HouseModel> houses = HouseModel.toModels(houseRepo.findHousesByCityId(cityId));
        for (HouseModel house: houses) {
            house.setApartmentCounts(getApartmentCountsByCityId(house.getId()));
            house.setAddress(getHouseAddress(house.getId()));
        } return houses;
    }

    public Long getApartmentCountsByCityId(int cityId) throws HouseNotFoundException {
        if (houseRepo.findById(cityId).isEmpty()) {
            throw new HouseNotFoundException("Дома в городе с id=" + cityId + " не найдены");
        } return houseRepo.countApartmentsByCityId(cityId);
    }

    public String getHouseAddress(int houseId) throws HouseNotFoundException {
        if (houseRepo.findById(houseId).isEmpty()) {
            throw new HouseNotFoundException("Дома с id=" + houseId + " не существует");
        }
        String houseNumber = houseRepo.findById(houseId).get().getNumber();
        String streetName = houseRepo.findById(houseId).get().getStreet().getName();
        String cityName = houseRepo.findById(houseId).get().getStreet().getCity().getName();
        return "Город: " + cityName + ", улица: " + streetName + ", дом: " + houseNumber;
    }
}
