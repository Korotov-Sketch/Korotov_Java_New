package com.project.things.dao;

import com.project.things.entities.FuelStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelStationRepository extends JpaRepository<FuelStation, Integer> {

}
