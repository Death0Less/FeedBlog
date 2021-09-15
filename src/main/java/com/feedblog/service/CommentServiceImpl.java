package com.feedblog.service;

import com.feedblog.dao.CommentDao;
import com.feedblog.model.Comment;
import com.feedblog.model.Post;
import com.feedblog.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentDao commentDao;

    public CommentServiceImpl(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public boolean add(Comment comment) {
       if (containsByContent(comment.getContent())) {
           return false;
       } else {
           commentDao.add(comment);
           return true;
       }
    }

    @Override
    public boolean deleteById(long id) {
        if (containsById(id)) {
            return false;
        } else {
            commentDao.deleteById(id);
            return true;
        }
    }

    @Override
    public Comment findById(long id) {
        return commentDao.findById(id);
    }

    @Override
    public List<Comment> findAll() {
        return commentDao.findAll();
    }

    @Override
    public boolean containsById(long id) {
        return commentDao.containsById(id);
    }

    @Override
    public boolean containsByContent(String content) {
        return commentDao.containsByContent(content);
    }

    @Override
    public List<Comment> findAllByUser(User user) {
        return commentDao.findAllByUser(user);
    }

    @Override
    public List<Comment> findAllByPost(Post post) {
        return commentDao.findAllByPost(post);
    }
}
