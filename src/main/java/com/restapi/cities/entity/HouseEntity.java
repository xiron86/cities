package com.restapi.cities.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Houses")
public class HouseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false)
    private int id;

    @Column(nullable=false, length=50)
    private String number;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "house")
    private List<ApartmentEntity> apartments;

    @ManyToOne
    @JoinColumn(name = "street_id", nullable=false)
    private StreetEntity street;

    public HouseEntity() {
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

    public List<ApartmentEntity> getApartments() {
        return apartments;
    }

    public void setApartments(List<ApartmentEntity> apartments) {
        this.apartments = apartments;
    }

    public StreetEntity getStreet() {
        return street;
    }

    public void setStreet(StreetEntity street) {
        this.street = street;
    }
}
