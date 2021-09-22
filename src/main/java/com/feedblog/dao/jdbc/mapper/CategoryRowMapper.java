package com.feedblog.dao.jdbc.mapper;

import com.feedblog.model.Category;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapper implements RowMapper<Category> {

    @Override
    public Category mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt(1);
        String categoryName = resultSet.getString(2);
        return new Category(id, categoryName);
    }
}
