package com.project.things.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GasStationsNetwork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Network_id;
    String NameOfNetwork;
    String website;

    public Integer getNetwork_id() {
        return Network_id;
    }

    public void setNetwork_id(Integer network_id) {
        this.Network_id = network_id;
    }

    public String getNameOfNetwork() {
        return NameOfNetwork;
    }

    public void setNameOfNetwork(String nameOfNetwork) {
        this.NameOfNetwork = nameOfNetwork;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public GasStationsNetwork() {
    }

    @Override
    public String toString() {
        return "" + this.getNetwork_id() + " " + this.getNameOfNetwork() + " " + this.getWebsite();
    }
}
