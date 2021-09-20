package com.feedblog.service;

import com.feedblog.dao.CommentDao;
import com.feedblog.model.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentDao commentDao;

    public CommentServiceImpl(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public void add(Comment comment) {
        commentDao.add(comment);
    }
}
