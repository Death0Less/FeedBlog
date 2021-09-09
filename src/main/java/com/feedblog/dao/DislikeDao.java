package com.feedblog.dao;

import com.feedblog.model.Dislike;

public interface DislikeDao {

    void add(Dislike dislike);
    void deleteById(long id);
    int getCount();
}
