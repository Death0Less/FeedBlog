package com.feedblog.service;

import com.feedblog.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserService userService = new UserServiceImpl();

    @Override
    public void add(User user) {
        userService.add(user);
    }

    @Override
    public void deleteById(long id) {
        userService.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        userService.deleteByName(name);
    }

    @Override
    public User findById(long id) {
        return userService.findById(id);
    }

    @Override
    public User findByName(String name) {
        return userService.findByName(name);
    }

    @Override
    public List<User> findAll() {
        return userService.findAll();
    }

    @Override
    public boolean containsById(long id) {
        return userService.containsById(id);
    }

    @Override
    public boolean containsByName(String name) {
        return userService.containsByName(name);
    }

    @Override
    public void updateUserByName(long id, String name) {
        userService.updateUserByName(id, name);
    }

    @Override
    public void updateByEmail(long id, String email) {
        userService.updateByEmail(id, email);
    }

    @Override
    public void updateByPassword(long id, String password) {
        userService.updateByPassword(id, password);
    }
}
