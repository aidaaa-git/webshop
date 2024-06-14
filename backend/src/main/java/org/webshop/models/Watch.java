package org.webshop.models;

public class Watch {
    private Integer id;
    private String name;
    private String brand;
    private Float price;
    private Integer subcategoryId;
    private Integer quantity;
    private String specifications;

    public Watch(Integer id, String name, String brand, Float price, Integer subcategoryId, Integer quantity, String specifications){
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.subcategoryId = subcategoryId;
        this.quantity = quantity;
        this.specifications = specifications;
    }
    public Watch(){}
    public Watch(Integer id, String name, String brand, Float price){
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }
    public Watch(Integer id, String name, String brand){
        this.id = id;
        this.name = name;
        this.brand = brand;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public Float getPrice() {
        return price;
    }

    public Integer getSubcategoryId() {
        return subcategoryId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSubcategoryId(Integer subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}

