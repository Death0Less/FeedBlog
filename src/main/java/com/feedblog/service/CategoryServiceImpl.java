package com.feedblog.service;

import com.feedblog.dao.CategoryDao;
import com.feedblog.model.Category;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public boolean add(Category category) {
        if (containsByTitle(category.getCategoryName())) {
            return false;
        } else {
            categoryDao.add(category);
            return true;
        }
    }


    @Override
    public boolean deleteById(long id) {
        if (containsById(id)) {
            categoryDao.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByTitle(String title) {
        if (containsByTitle(title)) {
            categoryDao.deleteByTitle(title);
            return true;
        }
        return false;
    }

    @Override
    public Category findById(long id) {
        return categoryDao.findById(id);
    }

    @Override
    public Category findByTitle(String title) {
        return categoryDao.findByTitle(title);
    }

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public boolean containsById(long id) {
        return categoryDao.containsById(id);
    }

    @Override
    public boolean containsByTitle(String title) {
        return categoryDao.containsByTitle(title);
    }
}
