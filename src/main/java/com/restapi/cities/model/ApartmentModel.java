package com.restapi.cities.model;

import com.restapi.cities.entity.ApartmentEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ApartmentModel {

    private int id;
    private float area;

    public ApartmentModel() {
    }

    public static ApartmentModel toModel(ApartmentEntity apartmentEntity) {
        ApartmentModel apartmentModel = new ApartmentModel();
        apartmentModel.setId(apartmentEntity.getId());
        apartmentModel.setArea(apartmentModel.getArea());
        return apartmentModel;
    }

    public static List<ApartmentModel> toModels(List<ApartmentEntity> apartments) {
        return apartments.stream().map(ApartmentModel::toModel).collect(Collectors.toList());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }
}
