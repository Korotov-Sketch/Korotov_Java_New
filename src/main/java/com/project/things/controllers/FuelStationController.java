package com.project.things.controllers;

import com.project.things.entities.FuelStation;
import com.project.things.services.FuelStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FuelStationController {
    @Autowired
    private FuelStationService fuelStationService;


    @PostMapping(value = "/createStation")
    public FuelStation createStation(@RequestParam(required = true) Integer Network_id,
                                     @RequestParam(required = true) String contacts){
        return fuelStationService.createStation(Network_id, contacts);
    }

    @GetMapping(value = "/getAllStations")
    public List<FuelStation> getAllStations(){
        return fuelStationService.getAllStations();
    }
    @GetMapping(value = "/getStation/{id}")
    public FuelStation getStationById(@PathVariable(value = "id") Integer id){
        return fuelStationService.getStationById(id);
    }
    @PatchMapping(value = "/updateStation")
    public FuelStation updateStationById(@RequestParam Integer id, @RequestParam Integer newNetworkId,
                                         @RequestParam(required = false, defaultValue = "Contacts") String newContacts){
        return fuelStationService.updateStation(id, newContacts);
    }

    @DeleteMapping(value = "/deleteStation")
    public void deleteStationById(Integer id){
        fuelStationService.deleteStation(id);
    }
}
