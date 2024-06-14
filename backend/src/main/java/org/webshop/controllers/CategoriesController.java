package org.webshop.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webshop.models.Category;
import org.webshop.models.Subcategory;
import org.webshop.services.CategoriesService;

import java.util.List;

@RestController
public class CategoriesController {
    private CategoriesService categoriesService;
    public CategoriesController(CategoriesService categoriesService){
        this.categoriesService = categoriesService;
    }
    @GetMapping("/getAllCategories")
    public List<Category> getAllCategories() {
        List<Category> categories = categoriesService.getAllCategories();
        return categories;
    }



}
