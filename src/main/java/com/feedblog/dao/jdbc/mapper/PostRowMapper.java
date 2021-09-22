package com.feedblog.dao.jdbc.mapper;

import com.feedblog.model.Category;
import com.feedblog.model.Post;
import com.feedblog.model.Tag;
import com.feedblog.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostRowMapper implements RowMapper<Post> {

    @Override
    public Post mapRow(ResultSet resultSet, int i) throws SQLException {
        int post_id = resultSet.getInt(1);
        String title = resultSet.getString(2);
        String description = resultSet.getString(3);
        boolean isChecked = resultSet.getBoolean(7);
        Date date = resultSet.getDate(8);
        int countOfViews = resultSet.getInt(9);

        String categoryName = resultSet.getString(11);

        String tagName = resultSet.getString(13);

        String userName = resultSet.getString(15);
        String userEmail = resultSet.getString(16);
        String userPassword = resultSet.getString(17);
        int userAge = resultSet.getInt(18);

        Category category = new Category(categoryName);
        Tag tag = new Tag(tagName);
        User user = new User(userName, userEmail, userPassword, userAge);

        return new Post(post_id, title, description, user, category, tag, isChecked, date, countOfViews);
    }
}
