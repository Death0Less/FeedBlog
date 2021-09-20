package com.feedblog.dao;

import com.feedblog.model.Category;
import com.feedblog.model.Post;
import com.feedblog.model.Tag;
import com.feedblog.model.User;

import java.util.List;

public interface PostDao {

    void add(Post post);
    void deleteById(long id);
    void deleteByTitle(String title);
    Post findById(long id);
    Post findByTitle(String title);
    List<Post> findAll();
    boolean containsById(long id);
    boolean containsByTitle(String title);
    void updateTag(long id, Tag tag);
    void updateDescription(long id, String description);
    void updateCategory(long id, Category category);
 }
