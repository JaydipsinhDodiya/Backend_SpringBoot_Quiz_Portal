package com.exam.service;

import com.exam.model.exam.Category;

import java.util.Set;

public interface CategoryService {

    //add
    public Category addCategory(Category category);

    //update
    public Category updateCategory(Category category);

    //get all
    public Set<Category> getAllCategories();

    //get by id
    public Category getCategoryById(Long categoryId);

    //delete by id
    public void deleteCategory(Long categoryId);

}
