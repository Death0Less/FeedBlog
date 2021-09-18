package com.feedblog.service;

import com.feedblog.dao.UserDao;
import com.feedblog.model.Role;
import com.feedblog.model.User;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final UserDao userDao;

    public RegistrationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean registrate(User user) {
        if (userDao.containsByName(user.getName())) {
            return false;
        } else {
            if(user.getName().equals("admin")) {
                user.setRole(Role.ADMIN);
            } else {
                user.setRole(Role.USER);
            }
            userDao.add(user);
            return true;
        }
    }
}
