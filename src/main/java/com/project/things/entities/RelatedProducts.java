package com.project.things.entities;

import javax.persistence.*;

@Entity
public class RelatedProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Product_id;
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

    public Integer getProduct_id() {
        return Product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.Product_id = product_id;
    }


    public RelatedProducts() {
    }

    @Override
    public String toString() {
        return "" + Product_id + " " + description + " " + name ;
    }
}
