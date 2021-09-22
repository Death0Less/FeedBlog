package com.feedblog.dao.jdbc;

import com.feedblog.dao.CategoryDao;
import com.feedblog.dao.jdbc.mapper.CategoryRowMapper;
import com.feedblog.model.Category;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcCategoryDao implements CategoryDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCategoryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(Category category) {
        jdbcTemplate.update("insert into categories values(default, ?)", category.getCategoryName());
    }

    @Override
    public void deleteById(long id) {
        jdbcTemplate.update("delete from categories where id = ?", id);
    }

    @Override
    public void deleteByTitle(String title) {
        jdbcTemplate.update("delete from categories where category_name = ?", title);
    }

    @Override
    public Category findById(long id) {
        return jdbcTemplate.queryForObject("select * from categories where id = ?", new Object[]{id}, new CategoryRowMapper());
    }

    @Override
    public Category findByTitle(String title) {
        return jdbcTemplate.queryForObject("select * from categories where category_name = ?", new Object[]{title}, new CategoryRowMapper());
    }

    @Override
    public List<Category> findAll() {
        return jdbcTemplate.query("select * from categories", new CategoryRowMapper());
    }

    @Override
    public boolean containsById(long id) {
        try {
            jdbcTemplate.queryForObject("select * from categories where id = ?", new Object[]{id}, new CategoryRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean containsByTitle(String title) {
       try {
           jdbcTemplate.queryForObject("select * from categories where category_name = ?", new Object[]{title}, new CategoryRowMapper());
       } catch (EmptyResultDataAccessException e) {
           return false;
       }
       return true;
    }
}
