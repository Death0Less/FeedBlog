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
        for (Tag tag : tagList) {
            if (tag.getId() == id) {
                tagList.remove(tag);
                break;
            }
        }
    }

    @Override
    public void deleteByName(String name) {
        for (Tag tag : tagList) {
            if (tag.getTagName().equals(name)) {
                tagList.remove(tag);
                break;
            }
        }
    }

    @Override
    public Tag findById(long id) {
        for (Tag tag : tagList) {
            if (tag.getId() == id) {
                return tag;
            }
        }
        return null;
    }

    @Override
    public Tag findByName(String name) {
        for (Tag tag : tagList) {
            if (tag.getTagName().equals(name)) {
                return tag;
            }
        }
        return null;
    }

    @Override
    public List<Tag> findAll() {
        return tagList;
    }

    @Override
    public boolean containsById(long id) {
        for (Tag tag : tagList) {
            if (tag.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsByName(String name) {
        for (Tag tag : tagList) {
            if (tag.getTagName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
