package com.feedblog.service;

import com.feedblog.dao.LikeDao;
import com.feedblog.model.Like;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {

    private final LikeDao likeDao;

    public LikeServiceImpl(LikeDao likeDao) {
        this.likeDao = likeDao;
    }

    @Override
    public void add(Like like) {
        likeDao.add(like);
    }

    @Override
    public void deleteById(long id) {
        likeDao.deleteById(id);
    }


    @Override
    public int getCount() {
        return likeDao.getCount();
    }
}
