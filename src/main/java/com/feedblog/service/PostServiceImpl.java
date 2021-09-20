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
    public boolean add(Post post) {
        if (containsByTitle(post.getTitle())) {
            return false;
        } else {
            postDao.add(post);
            return true;
        }
    }

    @Override
    public boolean deleteById(long id) {
        if (containsById(id)) {
            postDao.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteByTitle(String title) {
        if (containsByTitle(title)) {
            postDao.deleteByTitle(title);
            return true;
        } else {
            return false;
        }
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
    public void updateTag(long id, Tag tag) {
        postDao.updateTag(id, tag);
    }

    @Override
    public void updateDescription(long id, String description) {
        postDao.updateDescription(id, description);
    }

    @Override
    public void updateCategory(long id, Category category) {
        postDao.updateCategory(id, category);
    }


}
