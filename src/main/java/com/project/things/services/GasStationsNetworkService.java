package com.project.things.services;

import com.project.things.dao.GasStationsNetworkRepository;
import com.project.things.entities.GasStationsNetwork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GasStationsNetworkService {

    @Autowired
    private GasStationsNetworkRepository repo;

    public GasStationsNetwork createNetwork(String name, String website){
        GasStationsNetwork gasStationsNetwork = new GasStationsNetwork();
        gasStationsNetwork.setNameOfNetwork(name);
        gasStationsNetwork.setWebsite(website);
        repo.save(gasStationsNetwork);
        return gasStationsNetwork;
    }
    public GasStationsNetwork getNetworkById(Integer id){
        GasStationsNetwork gasStationsNetwork = repo.findById(id).get();
        return gasStationsNetwork;
    }
    public GasStationsNetwork getNetworkByName(String name){
        GasStationsNetwork gasStationsNetwork = repo.findAll().stream().filter(elem -> elem.getNameOfNetwork() == name)
                .findFirst().get();
        return gasStationsNetwork;
    }
    public List<GasStationsNetwork> getAllNetworks(){
        return repo.findAll();
    }

    public GasStationsNetwork updateNetworkById(Integer id, String newName, String newWebSite){
        GasStationsNetwork gasStationsNetwork = repo.findById(id).get();
        gasStationsNetwork.setNameOfNetwork(newName);
        gasStationsNetwork.setWebsite(newWebSite);
        return repo.save(gasStationsNetwork);
    }
    public void deleteNetworkById(Integer id){
        repo.deleteById(id);
    }
    public List<String> getAllStationsAndNetworks(){
        return repo.getAllStationsAndNetworks();
    }

}
