package com.exam.service.Impl;

import com.exam.model.exam.Category;
import com.exam.repository.CategoryRepository;
import com.exam.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    //Add
    @Override
    public Category addCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    //Update
    @Override
    public Category updateCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    //Get All
    @Override
    public Set<Category> getAllCategories() {
        return new LinkedHashSet<>(this.categoryRepository.findAll());
    }

    //Get By Id
    @Override
    public Category getCategoryById(Long categoryId) {
        return this.categoryRepository.getById(categoryId);
    }

    //Delete
    @Override
    public void deleteCategory(Long categoryId) {

        this.categoryRepository.deleteById(categoryId);

    }
}
