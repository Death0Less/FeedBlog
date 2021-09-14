package com.feedblog.dao.inmemory;

import com.feedblog.dao.UserDao;
import com.feedblog.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryUserDao implements UserDao {

    private final List<User> userList = new ArrayList<>();

    private static long incId;

    @Override
    public void add(User user) {
        user.setId(incId++);
        userList.add(user);
    }

    @Override
    public void deleteById(long id) {
        for (User user : userList) {
            if (user.getId() == id) {
                userList.remove(user);
                break;
            }
        }
    }

    @Override
    public void deleteByName(String name) {
        for (User user : userList) {
            if (user.getName().equals(name)) {
                userList.remove(user);
                break;
            }
        }
    }

    @Override
    public User findById(long id) {
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User findByName(String name) {
        for (User user : userList) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return userList;
    }

    @Override
    public boolean containsById(long id) {
        for (User user : userList) {
            if (user.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsByName(String name) {
        for (User user : userList) {
            if (user.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void updateUserByName(long id, String name) {
        for (User user : userList) {
            if (user.getId() == id) {
                user.setName(name);
                break;
            }
        }
    }

    @Override
    public void updateByEmail(long id, String email) {
        for (User user : userList) {
            if (user.getId() == id) {
                user.setEmail(email);
                break;
            }
        }
    }

    @Override
    public void updateByPassword(long id, String password) {
        for (User user : userList) {
            if (user.getId() == id) {
                user.setPassword(password);
                break;
            }
        }
    }
}
