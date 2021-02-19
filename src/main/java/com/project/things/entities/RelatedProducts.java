package com.project.things.entities;

import javax.persistence.*;

@Entity
public class RelatedProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer item_id;
    String name;
    String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }


    public RelatedProducts() {
    }

    @Override
    public String toString() {
        return "" + item_id + " " + description + " " + name ;
    }
}
