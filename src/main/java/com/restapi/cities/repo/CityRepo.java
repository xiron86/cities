package com.restapi.cities.repo;

import com.restapi.cities.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CityRepo extends JpaRepository<CityEntity, Integer> {
    @Query(value="SELECT count(houses) FROM cities JOIN streets ON cities.id=streets.city_id JOIN houses ON streets.id=houses.street_id WHERE cities.id=:id", nativeQuery=true)
    long countHousesByCityId(@Param("id") long id);
}