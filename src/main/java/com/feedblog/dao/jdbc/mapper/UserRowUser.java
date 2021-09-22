package com.feedblog.dao.jdbc.mapper;

import com.feedblog.model.Role;
import com.feedblog.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowUser implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        int user_id = resultSet.getInt(1);
        String name = resultSet.getString(2);
        String email = resultSet.getString(3);
        String password = resultSet.getString(4);
        int age = resultSet.getInt(5);
        String role = resultSet.getString(8);
        return new User(user_id, name, email, password, age, Role.valueOf(role));
    }
}
