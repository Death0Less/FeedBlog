package com.feedblog.dao.inmemory;

import com.feedblog.dao.CategoryDao;
import com.feedblog.model.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCategoryDao implements CategoryDao {

    private final List<Category> categoryList = new ArrayList<>();
    private static long incId = 1;

    @Override
    public void add(Category category) {
        category.setId(incId++);
        categoryList.add(category);
    }

    @Override
    public void deleteById(long id) {
        categoryList.removeIf(category -> category.getId() == id);
    }

    @Override
    public void deleteByTitle(String title) {
        categoryList.removeIf(category -> category.getCategoryName().equals(title));
    }

    @Override
    public Category findById(long id) {
       return categoryList.stream().filter(category -> category.getId() == id).findAny().orElse(null);
    }

    @Override
    public Category findByTitle(String title) {
        return categoryList.stream().filter(category -> category.getCategoryName().equals(title)).findAny().orElse(null);
    }

    @Override
    public List<Category> findAll() {
        return categoryList;
    }

    @Override
    public boolean containsById(long id) {
        return categoryList.stream().anyMatch(category -> category.getId() == id);
    }

    @Override
    public boolean containsByTitle(String title) {
        return categoryList.stream().anyMatch(category -> category.getCategoryName().equals(title));
    }
}
