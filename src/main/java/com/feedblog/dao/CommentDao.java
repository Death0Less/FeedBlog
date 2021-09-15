package com.feedblog.dao;

import com.feedblog.model.Comment;
import com.feedblog.model.Post;
import com.feedblog.model.User;

import java.util.List;

public interface CommentDao {

    void add(Comment comment);
    void deleteById(long id);
    Comment findById(long id);
    List<Comment> findAll();
    boolean containsByContent(String content);
    boolean containsById(long id);
    List<Comment> findAllByUser(User User);
    List<Comment> findAllByPost(Post post);
}
