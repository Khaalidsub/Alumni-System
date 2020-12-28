/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.InputStream;

/**
 *
 * @author Khalid
 */
public class Bicycle {
    private int id;
    private String name;
    private String type;
    private int rent_cost, length;
    private InputStream image;

    public Bicycle(int id, String name, String type, int rent_cost, InputStream image) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.rent_cost = rent_cost;
        this.image = image;
    }

    public Bicycle() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRent_cost() {
        return rent_cost;
    }

    public void setRent_cost(int rent_cost) {
        this.rent_cost = rent_cost;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public InputStream getImage() {
        return image;
    }

    public int getLength() {
        return length;
    }

    
    
}
