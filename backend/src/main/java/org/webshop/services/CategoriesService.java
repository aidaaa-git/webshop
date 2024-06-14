package org.webshop.services;

import org.springframework.stereotype.Service;
import org.webshop.models.Category;
import org.webshop.models.Subcategory;
import org.webshop.repositories.CategoryRepository;

import javax.tools.JavaCompiler;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CategoriesService {
    private CategoryRepository categoryRepository;
    public CategoriesService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    public List<Category> getAllCategories(){
        List<Category> categories = categoryRepository.getAllCategories();
        List<Subcategory> subcategories = categoryRepository.getAllSubcategories();
        Map<Integer, Category> categoryMap =  categories.stream().collect(Collectors.toMap(Category::getId, x -> x));
        for(Subcategory subcategory : subcategories){
            Category category = categoryMap.get(subcategory.getCategoryId());
            category.addSubcategoryToList(subcategory);
        }
        return new ArrayList<>(categoryMap.values());
    }


}
