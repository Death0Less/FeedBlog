package com.feedblog.service;

import com.feedblog.model.Comment;
import com.feedblog.model.Post;
import com.feedblog.model.User;

import java.util.List;

public class CommentServiceImpl implements CommentService {

    private CommentService commentService = new CommentServiceImpl();

    @Override
    public void add(Comment comment) {
        commentService.add(comment);
    }

    @Override
    public void deleteById(long id) {
        commentService.deleteById(id);
    }

    @Override
    public Comment findById(long id) {
        return commentService.findById(id);
    }

    @Override
    public List<Comment> findAll() {
        return commentService.findAll();
    }

    @Override
    public boolean containsById(long id) {
        return commentService.containsById(id);
    }

    @Override
    public List<Comment> findAllByUser(User user) {
        return commentService.findAllByUser(user);
    }

    @Override
    public List<Comment> findAllByPost(Post post) {
        return commentService.findAllByPost(post);
    }
}
