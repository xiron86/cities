package com.restapi.cities.model;

import com.restapi.cities.entity.HouseEntity;

import java.util.List;
import java.util.stream.Collectors;

public class HouseModel {

    private int id;
    private String number;
    private Long apartmentCounts;
    private String address;

    public HouseModel() {
    }

    public static HouseModel toModel(HouseEntity houseEntity) {
        HouseModel houseModel = new HouseModel();
        houseModel.setId(houseEntity.getId());
        houseModel.setNumber(houseEntity.getNumber());
        return houseModel;
    }

    public static List<HouseModel> toModels(List<HouseEntity> houseEntities) {
        return houseEntities.stream().map(HouseModel::toModel).collect(Collectors.toList());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getApartmentCounts() {
        return apartmentCounts;
    }

    public void setApartmentCounts(Long apartmentCounts) {
        this.apartmentCounts = apartmentCounts;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
