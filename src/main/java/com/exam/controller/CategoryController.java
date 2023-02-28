package com.exam.controller;

import com.exam.model.exam.Category;
import com.exam.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //Add category
    @PostMapping("/")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {

        Category addCategory = this.categoryService.addCategory(category);
        return ResponseEntity.ok(addCategory);
    }

    //Get category
    @GetMapping("/{categoryId}")
    public Category getCategory(@PathVariable("categoryId") Long categoryId) {
        return this.categoryService.getCategoryById(categoryId);
    }

    //Get all categories
    @GetMapping("/")
    public ResponseEntity<?> getAllCategories() {
        return ResponseEntity.ok(this.categoryService.getAllCategories());
    }

    //update Category
    @PutMapping("/")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {

        Category updateCategory = this.categoryService.updateCategory(category);
        return ResponseEntity.ok(updateCategory);
    }

    //delete category
    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId) {
        this.categoryService.deleteCategory(categoryId);
    }

}
