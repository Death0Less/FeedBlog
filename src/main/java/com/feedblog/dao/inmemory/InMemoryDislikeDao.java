package com.feedblog.dao.inmemory;

import com.feedblog.dao.DislikeDao;
import com.feedblog.model.Dislike;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDislikeDao implements DislikeDao {

    private final List<Dislike> dislikeList = new ArrayList<>();

    private static long incId = 1;

    @Override
    public void add(Dislike dislike) {
        dislike.setId(incId++);
        dislikeList.add(dislike);
    }

    @Override
    public void deleteById(long id) {
        for (Dislike dislike : dislikeList) {
            if (dislike.getId() == id) {
                dislikeList.remove(dislike);
                break;
            }
        }
    }

    @Override
    public int getCount() {
        return dislikeList.size();
    }
}
