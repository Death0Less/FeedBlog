package com.feedblog.dao.inmemory;

import com.feedblog.dao.CommentDao;
import com.feedblog.model.Comment;
import com.feedblog.model.Post;
import com.feedblog.model.User;

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

    @Override
    public void deleteById(long id) {
        for (Comment comment : commentList) {
            if (comment.getId() == id) {
                commentList.remove(comment);
                break;
            }
        }
    }

    @Override
    public Comment findById(long id) {
        for (Comment comment : commentList) {
            if (comment.getId() == id) {
                return comment;
            }
        }
        return null;
    }

    @Override
    public List<Comment> findAll() {
        return commentList;
    }

    @Override
    public boolean containsById(long id) {
        for (Comment comment : commentList) {
            if (comment.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Comment> findAllByUser(User user) {
        List<Comment> commentList1 = new ArrayList<>();
        for (Comment comment : commentList) {
            if (comment.getUser().getName().equals(user.getName())) {
                commentList1.add(comment);
                return commentList1;
            }
        }
        return null;
    }

    @Override
    public List<Comment> findAllByPost(Post post) {
        List<Comment> commentList2 = new ArrayList<>();
        for (Comment comment : commentList2) {
            if (comment.getPost().getTitle().equals(post.getTitle())) {
                commentList2.add(comment);
                return commentList2;
            }
        }
        return null;
    }
}
