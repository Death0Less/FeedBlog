package com.feedblog.dao.jdbc;

import com.feedblog.dao.UserDao;
import com.feedblog.dao.jdbc.mapper.UserRowUser;
import com.feedblog.model.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcUserDao implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(User user) {
        jdbcTemplate.update("insert into users values (default, ?, ?, ?, ?, ?)", user.getName(), user.getEmail(),
                user.getPassword(), user.getAge(), 2);
    }

    @Override
    public void deleteById(long id) {
        jdbcTemplate.update("delete from users where id = ?", id);
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from users where name = ?", name);
    }

    @Override
    public User findById(long id) {
        return jdbcTemplate.queryForObject("select * from users as u join roles as r on u.role_id = r.id where u.id = ?",
                new Object[]{id}, new UserRowUser());
    }

    @Override
    public User findByName(String name) {
        return jdbcTemplate.queryForObject("select * from users as u join roles as r on u.role_id = r.id where name = ?",
                new Object[]{name}, new UserRowUser());
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select * from users as u join roles as r on u.role_id = r.id", new UserRowUser());
    }

    @Override
    public boolean containsById(long id) {
        try {
            jdbcTemplate.queryForObject("select * from users as u join roles as r on u.role_id = r.id where u.id = ?",
                    new Object[]{id}, new UserRowUser());
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean containsByName(String name) {
        try {
            jdbcTemplate.queryForObject("select * from users as u join roles as r on u.role_id = r.id where name = ?",
                    new Object[]{name}, new UserRowUser());
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
        return true;
    }

    @Override
    public void updateByName(long id, String name) {
        jdbcTemplate.update("update users set name = ? where id = ?", name, id);
    }

    @Override
    public void updateByEmail(long id, String email) {
        jdbcTemplate.update("update users set email = ? where id = ?", email, id);
    }

    @Override
    public void updateByPassword(long id, String password) {
        jdbcTemplate.update("update users set password = ? where id = ?", password, id);

    }
}
