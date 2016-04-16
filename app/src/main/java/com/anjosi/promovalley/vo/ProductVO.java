package com.anjosi.promovalley.vo;

/**
 * Created by OneSecond on 16/04/2016.
 */
public class ProductVO {

    private Integer id;

    private String name;

    private String location;

    private Float price;

    //GETTERS AND SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
