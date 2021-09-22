package com.feedblog.dao.jdbc;

import com.feedblog.dao.TagDao;
import com.feedblog.dao.jdbc.mapper.TagRowMapper;
import com.feedblog.model.Tag;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcTagDao implements TagDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTagDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(Tag tag) {
        jdbcTemplate.update("insert into tags values(default, ?)", tag.getTagName());
    }

    @Override
    public void deleteById(long id) {
        jdbcTemplate.update("delete from tags where id = ?", id);
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from tags where tag_name = ?", name);
    }

    @Override
    public Tag findById(long id) {
        return jdbcTemplate.queryForObject("select * from tags where id = ?", new Object[]{id}, new TagRowMapper());
    }

    @Override
    public Tag findByName(String name) {
        return jdbcTemplate.queryForObject("select * from tags where tag_name = ?", new Object[]{name}, new TagRowMapper());
    }

    @Override
    public List<Tag> findAll() {
        return jdbcTemplate.query("select * from tags", new TagRowMapper());
    }

    @Override
    public boolean containsById(long id) {
        try {
            jdbcTemplate.queryForObject("select * from tags where id = ?", new Object[]{id}, new TagRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean containsByName(String name) {
        try {
            jdbcTemplate.queryForObject("select * from tags where tag_name = ?", new Object[]{name}, new TagRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
        return true;
    }
}
