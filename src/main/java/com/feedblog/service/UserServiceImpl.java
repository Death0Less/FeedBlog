package com.feedblog.service;

import com.feedblog.dao.UserDao;
import com.feedblog.model.Role;
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
    public boolean add(User user) {
        if (containsByName(user.getName())) {
            return false;
        } else {
            userDao.add(user);
            return true;
        }
    }

    @Override
    public boolean deleteById(long id) {
        if (containsById(id)) {
            userDao.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteByName(String name) {
        if (containsByName(name)) {
            userDao.deleteByName(name);
            return true;
        } else {
            return false;
        }
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
    public void updateByName(long id, String name) {
        userDao.updateByName(id, name);
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
