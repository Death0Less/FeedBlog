package com.feedblog.dao.inmemory;

import com.feedblog.dao.CommentDao;
import com.feedblog.model.Comment;
import com.feedblog.model.Post;
import com.feedblog.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCommentDao implements CommentDao {

    private final List<Comment> commentList = new ArrayList<>();

    private static long incId = 1;

    @Override
    public void add(Comment comment) {
        comment.setId(incId++);
        commentList.add(comment);
    }
}
