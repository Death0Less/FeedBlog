package com.feedblog.dao.jdbc;

import com.feedblog.dao.CommentDao;
import com.feedblog.model.Comment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcCommentDao implements CommentDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCommentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(Comment comment) {
        jdbcTemplate.update("insert into comments value (default, ?, ?, ?)", comment.getId(), comment.getUser().getId(),
                comment.getPost().getId());
    }
}
