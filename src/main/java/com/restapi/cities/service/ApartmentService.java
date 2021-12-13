package com.restapi.cities.service;

import com.restapi.cities.repo.ApartmentRepo;
import com.restapi.cities.exception.ApartmentNotFoundException;
import com.restapi.cities.model.ApartmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApartmentService {

    @Autowired
    private ApartmentRepo apartmentRepo;

    public ApartmentModel getApartment(int id) throws ApartmentNotFoundException {
        if (apartmentRepo.findById(id).isEmpty()) {
            throw new ApartmentNotFoundException("Квартира c id=" + id + " не найдена");
        } return ApartmentModel.toModel(apartmentRepo.findById(id).get());
    }
}
