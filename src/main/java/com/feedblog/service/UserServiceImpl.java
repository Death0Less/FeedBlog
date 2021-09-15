package com.feedblog.service;

import com.feedblog.dao.UserDao;
import com.feedblog.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void deleteById(long id) {
        userDao.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        userDao.deleteByName(name);
    }

    @Override
    public User findById(long id) {
        return userDao.findById(id);
    }

    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public boolean containsById(long id) {
        return userDao.containsById(id);
    }

    @Override
    public boolean containsByName(String name) {
        return userDao.containsByName(name);
    }

    @Override
    public void updateUserByName(long id, String name) {
        userDao.updateUserByName(id, name);
    }

    @Override
    public void updateByEmail(long id, String email) {
        userDao.updateByEmail(id, email);
    }

    @Override
    public void updateByPassword(long id, String password) {
        userDao.updateByPassword(id, password);
    }
}
