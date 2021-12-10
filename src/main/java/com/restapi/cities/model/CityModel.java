package com.restapi.cities.model;

import com.restapi.cities.entity.CityEntity;

import java.util.List;
import java.util.stream.Collectors;

public class CityModel {

    private int id;
    private String name;
    private Long houseCounts;

    public CityModel() {
    }

    public static CityModel toModel(CityEntity cityEntity) {
        CityModel cityModel = new CityModel();
        cityModel.setId(cityEntity.getId());
        cityModel.setName(cityEntity.getName());
        return cityModel;
    }

    public static List<CityModel> toModels(List<CityEntity> cityEntities) {
        return cityEntities.stream().map(CityModel::toModel).collect(Collectors.toList());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHouseCounts() {
        return houseCounts;
    }

    public void setHouseCounts(Long houseCounts) {
        this.houseCounts = houseCounts;
    }
}
