/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.store;

/**
 *
 * @author Bassam Muhammad
 */
public class Item {
    private String name;
    private long id;
    private double cost;

    public Item(String name, double cost, long id) {
        this.name = name;
        this.cost = cost;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product ID: " + getId() + "     Product name: " + getName() + "     Cost: Rs." + getCost();
    }
    
    
}
