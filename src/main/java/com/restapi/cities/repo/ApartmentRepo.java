package com.restapi.cities.repo;

import com.restapi.cities.entity.ApartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentRepo extends JpaRepository<ApartmentEntity, Integer> {
}
