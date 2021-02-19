package com.project.things.entities;

import javax.persistence.*;


@Entity
public class FuelStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer station_id;
    @ManyToOne
    GasStationsNetwork gasStationsNetwork;
    String contacts;

    public Integer getStation_id() {
        return station_id;
    }

    public void setStation_id(Integer station_id) {
        this.station_id = station_id;
    }

    public GasStationsNetwork getGasStationsNetwork() {
        return gasStationsNetwork;
    }

    public void setGasStationsNetwork(GasStationsNetwork gasStationsNetwork) {
        this.gasStationsNetwork = gasStationsNetwork;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public FuelStation() {
    }

    @Override
    public String toString() {
        return "" + this.station_id + " " + this.contacts + " " + gasStationsNetwork.getNetwork_id();
    }
}
