package com.feedblog.dao;

import com.feedblog.model.Like;

public interface LikeDao {

    void add(Like like);
    void deleteById(long id);
    int getCount();
}
