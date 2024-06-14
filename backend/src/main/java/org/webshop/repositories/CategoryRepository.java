package org.webshop.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.tags.form.SelectTag;
import org.webshop.models.Category;
import org.webshop.models.Subcategory;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository {
    private JdbcTemplate jdbcTemplate;
    public CategoryRepository (JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>(
                jdbcTemplate.query("SELECT id, name FROM category", (rs, rowNum) -> {
                    return new Category(rs.getInt("id"), rs.getString("name"));
                }));
        return categories;
    }
    public List<Subcategory> getAllSubcategories() {
        List<Subcategory> subcategories = new ArrayList<>(
                jdbcTemplate.query("SELECT id, name, categoryId FROM subcategory", (rs, rowNum) -> {
                    return new Subcategory(rs.getInt("id"), rs.getString("name"), rs.getInt("categoryId"));
                }));
        return subcategories;
    }
}


