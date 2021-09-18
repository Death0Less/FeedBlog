package com.feedblog.service;

import com.feedblog.dao.UserDao;
import com.feedblog.model.User;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    private final UserDao userDao;

    public AuthorizationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean authorize(String name, String password) {
        for (User user : userDao.findAll()) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
               return true;
            }
        }
        return false;
    }
}
