package com.anjosi.promovalley.vo;

/**
 * Created by OneSecond on 16/04/2016.
 */
public class ItemProductVO {

    private Integer id;

    private String location;

    private Double price;

    //GETTERS AND SETTERS
    public Integer getId() { return id; }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
