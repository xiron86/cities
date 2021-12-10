package com.restapi.cities.repo;

import com.restapi.cities.entity.HouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HouseRepo extends JpaRepository<HouseEntity, Integer> {
    @Query(value="SELECT count(apartments) FROM houses JOIN apartments ON houses.id=apartments.house_id WHERE houses.street_id=:id", nativeQuery=true)
    long countApartmentsByStreetId(@Param("id") long id);

    @Query(value="SELECT count(apartments) FROM houses JOIN apartments ON houses.id=apartments.house_id JOIN streets ON houses.street_id=streets.id JOIN cities ON streets.city_id=cities.id WHERE cities.id=:id", nativeQuery=true)
    long countApartmentsByCityId(@Param("id") long id);

    @Query(value="SELECT houses.id, houses.number, houses.street_id FROM streets JOIN houses ON streets.id=houses.street_id WHERE streets.id=:id", nativeQuery=true)
    List<HouseEntity> findHousesByStreetId(@Param("id") long id);

    @Query(value="SELECT houses.id, houses.number, houses.street_id FROM streets JOIN houses ON streets.id=houses.street_id JOIN cities ON streets.city_id=cities.id WHERE cities.id=:id", nativeQuery=true)
    List<HouseEntity> findHousesByCityId(@Param("id") long id);
}
