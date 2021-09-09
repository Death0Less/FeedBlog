package com.feedblog.dao.inmemory;

import com.feedblog.dao.PostDao;
import com.feedblog.model.Category;
import com.feedblog.model.Post;
import com.feedblog.model.Tag;
import com.feedblog.model.User;

import java.util.ArrayList;
import java.util.List;

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
    public Post findByUser(User user) {
        for (Post post : postList) {
            if (post.getUser().getName().equals(user.getName())) {
                return post;
            }
        }
        return null;
    }

    @Override
    public void deleteByUser(User user) {
        for (Post post : postList) {
            if (post.getUser().getName().equals(user.getName())) {
                postList.remove(post);
            }
        }
    }

    @Override
    public Post findByCategory(Category category) {
        for (Post post : postList) {
            if (post.getCategory().getCategoryName().equals(category.getCategoryName())) {
                return post;
            }
        }
        return null;
    }

    @Override
    public void deleteByCategory(Category category) {
        for (Post post : postList) {
            if (post.getCategory().getCategoryName().equals(category.getCategoryName())) {
                postList.remove(post);
            }
        }
    }

    @Override
    public Post findByTag(Tag tag) {
        for (Post post : postList) {
            if (post.getTag().getTagName().equals(tag.getTagName())) {
                return post;
            }
        }
        return null;
    }

    @Override
    public void deleteByTag(Tag tag) {
        for (Post post : postList) {
            if (post.getTag().getTagName().equals(tag.getTagName())) {
                postList.remove(post);
            }
        }
    }

}