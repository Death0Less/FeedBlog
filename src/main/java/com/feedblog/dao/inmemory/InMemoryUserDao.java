package com.feedblog.dao.inmemory;

import com.feedblog.dao.UserDao;
import com.feedblog.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryUserDao implements UserDao {

    private final List<User> userList = new ArrayList<>();

    private static long incId = 1;

    @Override
    public void add(User user) {
        user.setId(incId++);
        userList.add(user);
    }

    @Override
    public void deleteById(long id) {
        userList.removeIf(user -> user.getId() == id);
    }

    @Override
    public void deleteByName(String name) {
        userList.removeIf(user -> user.getName().equals(name));
    }

    @Override
    public User findById(long id) {
        return userList.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    @Override
    public User findByName(String name) {
        return userList.stream().filter(user -> user.getName().equals(name)).findAny().orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userList;
    }

    @Override
    public boolean containsById(long id) {
        return userList.stream().anyMatch(user -> user.getId() == id);
    }

    @Override
    public boolean containsByName(String name) {
        return userList.stream().anyMatch(user -> user.getName().equals(name));
    }

    @Override
    public void updateByName(long id, String name) {
        userList.stream().filter(user -> user.getId() == id).forEach(user -> user.setName(name));
    }

    @Override
    public void updateByEmail(long id, String email) {
        userList.stream().filter(user -> user.getId() == id).forEach(user -> user.setEmail(email));
    }

    @Override
    public void updateByPassword(long id, String password) {
        userList.stream().filter(user -> user.getId() == id).forEach(user -> user.setPassword(password));
    }
}
