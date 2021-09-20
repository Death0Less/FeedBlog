package com.feedblog.dao;

import com.feedblog.model.Comment;
import com.feedblog.model.Post;
import com.feedblog.model.User;

import java.util.List;

public interface CommentDao {

    void add(Comment comment);
}
