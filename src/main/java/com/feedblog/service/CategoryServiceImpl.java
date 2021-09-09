package com.feedblog.service;

import com.feedblog.model.Category;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private CategoryService categoryService = new CategoryServiceImpl();

    @Override
    public void add(Category category) {
        categoryService.add(category);
    }

    @Override
    public void deleteById(long id) {
        categoryService.deleteById(id);
    }

    @Override
    public void deleteByTile(String title) {
        categoryService.deleteByTile(title);
    }

    @Override
    public Category findById(long id) {
        return categoryService.findById(id);
    }

    @Override
    public Category findByTitle(String title) {
        return categoryService.findByTitle(title);
    }

    @Override
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @Override
    public boolean containsById(long id) {
        return categoryService.containsById(id);
    }

    @Override
    public boolean containsByTitle(String title) {
        return categoryService.containsByTitle(title);
    }
}
