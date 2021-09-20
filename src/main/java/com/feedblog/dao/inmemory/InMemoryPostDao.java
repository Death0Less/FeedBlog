package com.feedblog.dao.inmemory;

import com.feedblog.dao.PostDao;
import com.feedblog.model.Category;
import com.feedblog.model.Post;
import com.feedblog.model.Tag;
import com.feedblog.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryPostDao implements PostDao {

    private final List<Post> postList = new ArrayList<>();

    private static long incId = 1;

    @Override
    public void add(Post post) {
        post.setId(incId++);
        postList.add(post);
    }

    @Override
    public void deleteById(long id) {
        for (Post post : postList) {
            if (post.getId() == id) {
                postList.remove(post);
                break;
            }
        }
    }

    @Override
    public void deleteByTitle(String title) {
        for (Post post : postList) {
            if (post.getTitle().equals(title)) {
                postList.remove(post);
                break;
            }
        }
    }

    @Override
    public Post findById(long id) {
        for (Post post : postList) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }

    @Override
    public Post findByTitle(String title) {
        for (Post post : postList) {
            if (post.getTitle().equals(title)) {
                return post;
            }
        }
        return null;
    }

    @Override
    public List<Post> findAll() {
        return postList;
    }

    @Override
    public boolean containsById(long id) {
        for (Post post : postList) {
            if (post.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsByTitle(String title) {
        for (Post post : postList) {
            if (post.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void updateDescription(long id, String description) {
        for (Post post : postList) {
            if (post.getId() == id) {
                post.setDescription(description);
            }
        }
    }

    @Override
    public void updateCategory(long id, Category category) {
        for (Post post : postList) {
            if (post.getId() == id) {
                post.setCategory(category);
            }
        }
    }


    @Override
    public void updateTag(long id, Tag tag) {
        for (Post post : postList) {
            if (post.getId() == id) {
                post.setTag(tag);
            }
        }
    }

}