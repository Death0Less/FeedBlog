package com.feedblog.service;

import com.feedblog.model.Category;
import com.feedblog.model.Post;
import com.feedblog.model.Tag;
import com.feedblog.model.User;

import java.util.List;

public class PostServiceImpl implements PostService {

    private PostService postService = new PostServiceImpl();

    @Override
    public void add(Post post) {
        postService.add(post);
    }

    @Override
    public void deleteById(long id) {
        postService.deleteById(id);
    }

    @Override
    public void deleteByTitle(String title) {
        postService.deleteByTitle(title);
    }

    @Override
    public Post findById(long id) {
        return postService.findById(id);
    }

    @Override
    public Post findByTitle(String title) {
        return postService.findByTitle(title);
    }

    @Override
    public List<Post> findAll() {
        return postService.findAll();
    }

    @Override
    public boolean containsById(long id) {
        return postService.containsById(id);
    }

    @Override
    public boolean containsByTitle(String title) {
        return postService.containsByTitle(title);
    }

    @Override
    public Post findByUser(User user) {
        return postService.findByUser(user);
    }

    @Override
    public void deleteByUser(User user) {
        postService.deleteByUser(user);
    }

    @Override
    public Post findByCategory(Category category) {
        return postService.findByCategory(category);
    }

    @Override
    public void deleteByCategory(Category category) {
        postService.deleteByCategory(category);
    }

    @Override
    public Post findByTag(Tag tag) {
        return postService.findByTag(tag);
    }

    @Override
    public void deleteByTag(Tag tag) {
        postService.deleteByTag(tag);
    }
}
