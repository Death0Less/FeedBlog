package com.feedblog.dao.inmemory;

import com.feedblog.dao.LikeDao;
import com.feedblog.model.Like;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryLikeDao implements LikeDao {

    private final List<Like> likeList = new ArrayList<>();

    private static long incId = 1;

    @Override
    public void add(Like like) {
        like.setId(incId++);
        likeList.add(like);
    }

    @Override
    public void deleteById(long id) {
        for (Like like : likeList) {
            if (like.getId() == id) {
                likeList.remove(like);
                break;
            }
        }
    }

    @Override
    public int getCount() {
        return likeList.size();
    }
}
