package org.webshop.models;

public class Subcategory {
    private Integer id;
    private String name;
    private Integer categoryId;
    public Subcategory(Integer id, String name, Integer categoryId){
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }
}
