package com.feedblog.dao;


import com.feedblog.model.Tag;

import java.util.List;

public interface TagDao {

    void add(Tag tag);
    void deleteById(long id);
    void deleteByName(String name);
    Tag findById(long id);
    Tag findByName(String name);
    List<Tag> findAll();
    boolean containsById(long id);
    boolean containsByName(String name);
}
