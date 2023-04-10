package com.example.shoplist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import com.example.shoplist.form.ProductForm;

import java.io.Serializable;

@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private boolean bought;

    public Product() {
    }

    public Product(ProductForm form) {
        this.name = form.getName();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }
}
