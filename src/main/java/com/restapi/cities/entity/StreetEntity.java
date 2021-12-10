package com.restapi.cities.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Streets")
public class StreetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false)
    private int id;

    @Column(nullable=false, length=100)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "street")
    private List<HouseEntity> houses;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable=false)
    private CityEntity city;

    public StreetEntity() {
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

    public List<HouseEntity> getHouses() {
        return houses;
    }

    public void setHouses(List<HouseEntity> houses) {
        this.houses = houses;
    }

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }
}
