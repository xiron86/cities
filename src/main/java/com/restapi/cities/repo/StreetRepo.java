package com.restapi.cities.repo;

import com.restapi.cities.entity.StreetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StreetRepo extends JpaRepository<StreetEntity, Integer> {
    @Query(value="SELECT count(houses) FROM streets JOIN houses ON streets.id=houses.street_id WHERE streets.id=:id", nativeQuery=true)
    long countHousesByStreetId(@Param("id") long id);

    @Query(value="SELECT streets.id, streets.name, streets.city_id FROM cities JOIN streets ON cities.id=streets.city_id WHERE cities.id=:id", nativeQuery=true)
    List<StreetEntity> findStreetsByCityId(@Param("id") long id);
}
