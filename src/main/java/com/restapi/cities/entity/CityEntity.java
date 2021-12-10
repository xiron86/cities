package com.restapi.cities.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Cities")
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false)
    private int id;

    @Column(nullable=false, length=100)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "city")
    private List<StreetEntity> streets;

    public CityEntity() {
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

    public List<StreetEntity> getStreets() {
        return streets;
    }

    public void setStreets(List<StreetEntity> streets) {
        this.streets = streets;
    }
}
