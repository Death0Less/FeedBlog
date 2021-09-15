package com.feedblog.service;

import com.feedblog.dao.TagDao;
import com.feedblog.model.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    private final TagDao tagDao;

    public TagServiceImpl(TagDao tagDao) {
        this.tagDao = tagDao;
    }

    @Override
    public boolean add(Tag tag) {
        if (containsByName(tag.getTagName())) {
            return false;
        } else {
            tagDao.add(tag);
            return true;
        }
    }

    @Override
    public boolean deleteById(long id) {
        if (containsById(id)) {
            tagDao.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByName(String name) {
        if (containsByName(name)) {
            tagDao.deleteByName(name);
            return true;
        }
        return false;
    }

    @Override
    public Tag findById(long id) {
        return tagDao.findById(id);
    }

    @Override
    public Tag findByName(String name) {
        return tagDao.findByName(name);
    }

    @Override
    public List<Tag> findAll() {
        return tagDao.findAll();
    }

    @Override
    public boolean containsById(long id) {
        return tagDao.containsById(id);
    }

    @Override
    public boolean containsByName(String name) {
        return tagDao.containsByName(name);
    }
}
