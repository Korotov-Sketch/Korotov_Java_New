package com.project.things.services;

import com.project.things.dao.GasStationsNetworkRepository;
import com.project.things.dao.FuelStationRepository;
import com.project.things.entities.FuelStation;
import com.project.things.entities.GasStationsNetwork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class FuelStationService {

    @Autowired
    private FuelStationRepository repo;
    @Autowired
    private GasStationsNetworkRepository networkRepo;

    public FuelStation createStation(Integer Network_id, String contacts){
        FuelStation fuelStation = new FuelStation();
        GasStationsNetwork gasStationsNetwork = networkRepo.findById(Network_id).get();
        fuelStation.setGasStationsNetwork(gasStationsNetwork);
        fuelStation.setContacts(contacts);
        repo.save(fuelStation);
        return fuelStation;
    }

    public FuelStation getStationById(Integer Station_id){
        return repo.findById(Station_id).get();
    }

    public List<FuelStation> getAllStations(){
        return repo.findAll();
    }

    public FuelStation updateStation(Integer shop_id, Integer newShopChain_id, String newContacts){
        FuelStation fuelStation = repo.findById(shop_id).get();
        GasStationsNetwork gasStationsNetwork = networkRepo.findById(shop_id).get();
        fuelStation.setGasStationsNetwork(gasStationsNetwork);
        fuelStation.setContacts(newContacts);
        return repo.save(fuelStation);
    }
    public void deleteStation(Integer shop_id){
        repo.deleteById(shop_id);
    }
}
