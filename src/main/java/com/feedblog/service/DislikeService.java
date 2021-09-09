package com.feedblog.service;

import com.feedblog.model.Dislike;

public interface DislikeService {

    void add(Dislike dislike);
    void deleteById(long id);
    int getCount();

}
