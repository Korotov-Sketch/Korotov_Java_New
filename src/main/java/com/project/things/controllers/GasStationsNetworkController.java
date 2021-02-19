package com.project.things.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.things.entities.GasStationsNetwork;
import com.project.things.services.GasStationsNetworkService;

import java.util.List;
import java.util.Map;

@RestController
public class GasStationsNetworkController {

    @Autowired
    private GasStationsNetworkService gasStationsNetworkService;

    @GetMapping("/")
    public String home(Map<String, Object> model) {
        return "empty page";
    }

    @PostMapping(value = "/createNetwork")
    public GasStationsNetwork createNetwork(@RequestParam(required = false, defaultValue = "имя") String newNameOfNetwork,
                                              @RequestParam(required = false, defaultValue = "сайт")String website){
        return  gasStationsNetworkService.createNetwork(newNameOfNetwork, website);
    }
    @GetMapping(value = "/getNetwork/{id}")
    public GasStationsNetwork getNetworkById(@PathVariable("id") Integer id) {

        return gasStationsNetworkService.getNetworkById(id);
    }

    @GetMapping(value = "/getAllNetworks")
    public List<GasStationsNetwork> getAllNetworks(){
        return gasStationsNetworkService.getAllNetworks();
    }

    @PatchMapping(value = "/updateNetwork/{id}")
    public GasStationsNetwork updateNetworkById(@PathVariable(value = "id") Integer id,
                                                  @RequestParam(required = false, defaultValue = "имя",
                                              name = "nameOfNetwork") String newNameOfNetwork,
                                                  @RequestParam(required = false, defaultValue = "сайт",
                                              name = "website") String newWebSite){
        return gasStationsNetworkService.updateNetworkById(id, newNameOfNetwork, newWebSite);
    }

    @DeleteMapping(value = "/deleteNetwork")
    public void deleteNetworkById(@RequestParam(required = true) Integer id){
        gasStationsNetworkService.deleteNetworkById(id);
    }

    @GetMapping(value = "/getAllStationsAndNetworks")
    public List<String> getAllStationsAndNetworks(){
        return gasStationsNetworkService.getAllStationsAndNetworks();
    }

}
