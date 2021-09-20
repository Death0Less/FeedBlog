package com.feedblog.dao.inmemory;

import com.feedblog.dao.TagDao;
import com.feedblog.model.Tag;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryTagDao implements TagDao {

    private final List<Tag> tagList = new ArrayList<>();

    private static long incId = 1;

    @Override
    public void add(Tag tag) {
        tag.setId(incId++);
        tagList.add(tag);
    }

    @Override
    public void deleteById(long id) {
        tagList.removeIf(tag -> tag.getId() == id);
    }

    @Override
    public void deleteByName(String name) {
        tagList.removeIf(tag -> tag.getTagName().equals(name));
    }

    @Override
    public Tag findById(long id) {
        return tagList.stream().filter(tag -> tag.getId() == id).findAny().orElse(null);
    }

    @Override
    public Tag findByName(String name) {
        return tagList.stream().filter(tag -> tag.getTagName().equals(name)).findAny().orElse(null);
    }

    @Override
    public List<Tag> findAll() {
        return tagList;
    }

    @Override
    public boolean containsById(long id) {
        return tagList.stream().anyMatch(tag -> tag.getId() == id);
    }

    @Override
    public boolean containsByName(String name) {
        return tagList.stream().anyMatch(tag -> tag.getTagName().equals(name));
    }
}
