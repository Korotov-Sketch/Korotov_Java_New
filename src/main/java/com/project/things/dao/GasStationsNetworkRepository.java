package com.project.things.dao;

import com.project.things.entities.GasStationsNetwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GasStationsNetworkRepository extends JpaRepository<GasStationsNetwork, Integer> {
    @Query(value = "select gas_stations_network.network_id, gas_stations_network.name_of_network, gas_stations_network.website," +
            "fuel_station.station_id, fuel_station.contacts from gas_stations_network inner join fuel_station on " +
            "gas_stations_network.network_id = fuel_station.gas_stations_network_network_id", nativeQuery = true)
    public List<String> getAllStationsAndNetworks();

}
