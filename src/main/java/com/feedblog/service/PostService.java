package com.feedblog.service;

import com.feedblog.model.Category;
import com.feedblog.model.Post;
import com.feedblog.model.Tag;
import com.feedblog.model.User;

import java.util.List;

public interface PostService {

    void add(Post post);
    void deleteById(long id);
    void deleteByTitle(String title);
    Post findById(long id);
    Post findByTitle(String title);
    List<Post> findAll();
    boolean containsById(long id);
    boolean containsByTitle(String title);

    Post findByUser(User user);
    void deleteByUser(User user);
    Post findByCategory(Category category);
    void deleteByCategory(Category category);
    Post findByTag(Tag tag);
    void deleteByTag(Tag tag);
}
