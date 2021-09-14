package com.feedblog.dao.inmemory;

import com.feedblog.dao.CategoryDao;
import com.feedblog.model.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
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
        for (Category category : categoryList) {
            if (category.getId() == id) {
                categoryList.remove(category);
                break;
            }
        }
    }

    @Override
    public void deleteByTitle(String title) {
        for (Category category : categoryList) {
            if (category.getCategoryName().equals(title)) {
                categoryList.remove(category);
                break;
            }
        }
    }

    @Override
    public Category findById(long id) {
        for (Category category : categoryList) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }

    @Override
    public Category findByTitle(String title) {
        for (Category category : categoryList) {
            if (category.getCategoryName().equals(title)) {
                return category;
            }
        }
        return null;
    }

    @Override
    public List<Category> findAll() {
        return categoryList;
    }

    @Override
    public boolean containsById(long id) {
        for (Category category : categoryList) {
            if (category.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsByTitle(String title) {
        for (Category category : categoryList) {
            if (category.getCategoryName().equals(title)) {
                return true;
            }
        }
        return false;
    }
}
