package com.feedblog.service;

import com.feedblog.model.Category;
import com.feedblog.model.Post;
import com.feedblog.model.Tag;
import com.feedblog.model.User;

import java.util.List;

public interface PostService {

    boolean add(Post post);
    boolean deleteById(long id);
    boolean deleteByTitle(String title);
    Post findById(long id);
    Post findByTitle(String title);
    List<Post> findAll();
    boolean containsById(long id);
    boolean containsByTitle(String title);
    void updateTag(long id, Tag tag);
    void updateDescription(long id, String description);
    void updateCategory(long id, Category category);

}
