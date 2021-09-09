package com.feedblog.service;

import com.feedblog.model.Like;

public class LikeServiceImpl implements LikeService {

    private LikeService likeService = new LikeServiceImpl();

    @Override
    public void add(Like like) {
        likeService.add(like);
    }

    @Override
    public void delete(long id) {
        likeService.delete(id);
    }

    @Override
    public int getCount() {
        return likeService.getCount();
    }
}
