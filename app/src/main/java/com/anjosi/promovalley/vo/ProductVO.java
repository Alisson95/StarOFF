package com.anjosi.promovalley.vo;

/**
 * Created by OneSecond on 16/04/2016.
 */
public class ProductVO {

    private Integer id;

    private String name;

    public ItemProductVO itemProduct;

    //GETTERS AND SETTERS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemProductVO getItemProduct() {
        return itemProduct;
    }

    public void setItemProduct(ItemProductVO itemProduct) {
        this.itemProduct = itemProduct;
    }
}
