package com.feedblog.dao;


import com.feedblog.model.User;

import java.util.List;

public interface UserDao {

    void add(User user);
    void deleteById(long id);
    void deleteByName(String name);
    User findById(long id);
    User findByName(String name);
    List<User> findAll();
    boolean containsById(long id);
    boolean containsByName(String name);

    void updateUserByName(long id, String name);
    void updateByEmail(long id, String email);
    void updateByPassword(long id, String password);
}
