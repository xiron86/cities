package com.restapi.cities.entity;

import javax.persistence.*;

@Entity
@Table(name = "Apartments")
public class ApartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false)
    private int id;

    @Column(nullable=false, precision=15, scale=2)
    private float area;

    @ManyToOne
    @JoinColumn(name = "house_id", nullable=false)
    private HouseEntity house;

    public ApartmentEntity() {
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

    public HouseEntity getHouse() {
        return house;
    }

    public void setHouse(HouseEntity house) {
        this.house = house;
    }
}
