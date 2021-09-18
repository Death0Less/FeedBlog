package com.feedblog.service;

import com.feedblog.model.Tag;

import java.util.List;

public interface TagService {

    boolean add(Tag tag);
    boolean deleteById(long id);
    boolean deleteByName(String name);
    Tag findById(long id);
    Tag findByName(String name);
    List<Tag> findAll();
    boolean containsById(long id);
    boolean containsByName(String name);
}
