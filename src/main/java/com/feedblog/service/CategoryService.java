package com.feedblog.service;

import com.feedblog.model.Category;

import java.util.List;

public interface CategoryService {

    void add(Category category);
    void deleteById(long id);
    void deleteByTile(String title);
    Category findById(long id);
    Category findByTitle(String title);
    List<Category> findAll();
    boolean containsById(long id);
    boolean containsByTitle(String title);

}
