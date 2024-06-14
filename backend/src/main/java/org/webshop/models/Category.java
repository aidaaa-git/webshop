package org.webshop.models;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private Integer id;
    private List<Subcategory> subcategories;
    public Category(Integer id, String name){
        this.name = name;
        this.id = id;
        this.subcategories = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }
    public void addSubcategoryToList(Subcategory subcategory){
        subcategories.add(subcategory);
    }
}
