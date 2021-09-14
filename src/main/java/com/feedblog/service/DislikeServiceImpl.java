package com.feedblog.service;

import com.feedblog.dao.DislikeDao;
import com.feedblog.model.Dislike;
import org.springframework.stereotype.Service;

@Service
public class DislikeServiceImpl implements DislikeService {

    private final DislikeDao dislikeDao;

    public DislikeServiceImpl(DislikeDao dislikeDao) {
        this.dislikeDao = dislikeDao;
    }

    @Override
    public void add(Dislike dislike) {
        dislikeDao.add(dislike);
    }

    @Override
    public void deleteById(long id) {
        dislikeDao.deleteById(id);
    }

    @Override
    public int getCount() {
        return dislikeDao.getCount();
    }
}
