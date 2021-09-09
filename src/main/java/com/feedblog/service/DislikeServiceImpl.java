package com.feedblog.service;

import com.feedblog.model.Dislike;

public class DislikeServiceImpl implements DislikeService {

    private DislikeService dislikeService = new DislikeServiceImpl();

    @Override
    public void add(Dislike dislike) {
        dislikeService.add(dislike);
    }

    @Override
    public void deleteById(long id) {
        dislikeService.deleteById(id);
    }

    @Override
    public int getCount() {
        return dislikeService.getCount();
    }
}
