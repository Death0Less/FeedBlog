package com.feedblog.service;

import com.feedblog.model.Like;

public interface LikeService {

    void add(Like like);
    void delete(long id);
    int getCount();
}

