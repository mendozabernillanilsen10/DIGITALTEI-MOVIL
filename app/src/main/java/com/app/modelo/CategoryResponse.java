package com.app.modelo;

import java.util.List;

public class CategoryResponse {

    private Category category;
    private List<Subcategory> subcategories;


    public CategoryResponse(Category category, List<Subcategory> subcategories) {
        this.category = category;
        this.subcategories = subcategories;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }
}
