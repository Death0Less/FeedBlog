package com.feedblog.dao.jdbc;

import com.feedblog.dao.PostDao;
import com.feedblog.dao.jdbc.mapper.PostRowMapper;
import com.feedblog.model.Category;
import com.feedblog.model.Post;
import com.feedblog.model.Tag;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcPostDao implements PostDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPostDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(Post post) {
        jdbcTemplate.update("insert into posts values (default, ?, ?, ?, ?, ?, ?, ?, ?)", post.getTitle(), post.getDescription(),
                post.getUser().getId(), post.getCategory().getId(), post.getTag().getId(), false, post.getDate(), post.getCountViews());
    }

    @Override
    public void deleteById(long id) {
        jdbcTemplate.update("delete from posts where id = ?", id);
    }

    @Override
    public void deleteByTitle(String title) {
        jdbcTemplate.update("delete from posts where title = ?", title);
    }

    @Override
    public Post findById(long id) {
        return jdbcTemplate.queryForObject("select * from posts as p join users as u on p.user_id = u.id join categories as c on " +
                "p.category_id = c.id join tags as t on p.tag_id = t.id where p.id = ?", new Object[]{id}, new PostRowMapper());
    }

    @Override
    public Post findByTitle(String title) {
        return jdbcTemplate.queryForObject("select * from posts as p join users as u on p.user_id = u.id join categories as c on " +
                "p.category_id = c.id join tags as t on p.tag_id = t.id where p.title = ?", new Object[]{title}, new PostRowMapper());
    }

    @Override
    public List<Post> findAll() {
        return jdbcTemplate.query("select * from posts as p join users as u on p.user_id = u.id join categories as c on " +
                "p.category_id = c.id join tags as t on p.tag_id = t.id", new PostRowMapper());
    }

    @Override
    public boolean containsById(long id) {
        try {
            jdbcTemplate.queryForObject("select * from posts as p join users as u on p.user_id = u.id join categories as c on " +
                    "p.category_id = c.id join tags as t on p.tag_id = t.id where p.id = ?", new Object[]{id}, new PostRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean containsByTitle(String title) {
        try {
            jdbcTemplate.queryForObject("select * from posts as p join users as u on p.user_id = u.id join categories as c on " +
                    "p.category_id = c.id join tags as t on p.tag_id = t.id where p.title = ?", new Object[]{title}, new PostRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
        return true;
    }

    @Override
    public void updateTag(long id, Tag tag) {
        jdbcTemplate.update("update posts set tag_id = ? where id = ?", tag.getId(), id);
    }

    @Override
    public void updateDescription(long id, String description) {
        jdbcTemplate.update("update posts set description = ? where id = ?", description, id);
    }

    @Override
    public void updateCategory(long id, Category category) {
        jdbcTemplate.update("update posts set category_id = ? where id = ?", category.getId(), id);
    }
}
