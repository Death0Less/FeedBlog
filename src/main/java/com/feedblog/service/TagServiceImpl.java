package com.feedblog.service;

import com.feedblog.model.Tag;

import java.util.List;

public class TagServiceImpl implements TagService {

    private TagService tagService = new TagServiceImpl();

    @Override
    public void add(Tag tag) {
        tagService.add(tag);
    }

    @Override
    public void deleteById(long id) {
        tagService.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        tagService.deleteByName(name);
    }

    @Override
    public Tag findById(long id) {
        return tagService.findById(id);
    }

    @Override
    public Tag findByName(String name) {
        return tagService.findByName(name);
    }

    @Override
    public List<Tag> findAll() {
        return tagService.findAll();
    }

    @Override
    public boolean containsById(long id) {
        return tagService.containsById(id);
    }

    @Override
    public boolean containsByName(String name) {
        return tagService.containsByName(name);
    }
}
