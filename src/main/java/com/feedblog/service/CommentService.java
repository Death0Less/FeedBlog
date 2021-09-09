package com.feedblog.service;

import com.feedblog.model.Comment;
import com.feedblog.model.Post;
import com.feedblog.model.User;

import java.util.List;

public interface CommentService {

    void add(Comment comment);
    void deleteById(long id);
    Comment findById(long id);
    List<Comment> findAll();
    boolean containsById(long id);
    List<Comment> findAllByUser(User user);
    List<Comment> findAllByPost(Post post);

}
