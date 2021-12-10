package com.restapi.cities.model;

import com.restapi.cities.entity.StreetEntity;

import java.util.List;
import java.util.stream.Collectors;

public class StreetModel {

    private int id;
    private String name;
    private Long houseCounts;

    public StreetModel() {
    }

    public static StreetModel toModel(StreetEntity streetEntity) {
        StreetModel streetModel = new StreetModel();
        streetModel.setId(streetEntity.getId());
        streetModel.setName(streetEntity.getName());
        return streetModel;
    }

    public static List<StreetModel> toModels(List<StreetEntity> streetEntities) {
        return streetEntities.stream().map(StreetModel::toModel).collect(Collectors.toList());
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
