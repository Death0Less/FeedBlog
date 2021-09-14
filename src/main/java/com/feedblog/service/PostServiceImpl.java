package com.feedblog.service;

import com.feedblog.dao.PostDao;
import com.feedblog.model.Category;
import com.feedblog.model.Post;
import com.feedblog.model.Tag;
import com.feedblog.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostDao postDao;

    public PostServiceImpl(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public void add(Post post) {
        postDao.add(post);
    }

    @Override
    public void deleteById(long id) {
        postDao.deleteById(id);
    }

    @Override
    public void deleteByTitle(String title) {
        postDao.deleteByTitle(title);
    }

    @Override
    public Post findById(long id) {
        return postDao.findById(id);
    }

    @Override
    public Post findByTitle(String title) {
        return postDao.findByTitle(title);
    }

    @Override
    public List<Post> findAll() {
        return postDao.findAll();
    }

    @Override
    public boolean containsById(long id) {
        return postDao.containsById(id);
    }

    @Override
    public boolean containsByTitle(String title) {
        return postDao.containsByTitle(title);
    }

    @Override
    public Post findByUser(User user) {
        return postDao.findByUser(user);
    }

    @Override
    public void deleteByUser(User user) {
        postDao.deleteByUser(user);
    }

    @Override
    public Post findByCategory(Category category) {
        return postDao.findByCategory(category);
    }

    @Override
    public void deleteByCategory(Category category) {
        postDao.deleteByCategory(category);
    }

    @Override
    public Post findByTag(Tag tag) {
        return postDao.findByTag(tag);
    }

    @Override
    public void deleteByTag(Tag tag) {
        postDao.deleteByTag(tag);
    }
}
