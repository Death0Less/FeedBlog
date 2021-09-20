package com.feedblog.dao.inmemory;

import com.feedblog.dao.PostDao;
import com.feedblog.model.Category;
import com.feedblog.model.Post;
import com.feedblog.model.Tag;
import com.feedblog.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        postList.removeIf(post -> post.getId() == id);
    }

    @Override
    public void deleteByTitle(String title) {
        postList.removeIf(post -> post.getTitle().equals(title));
    }

    @Override
    public Post findById(long id) {
        return postList.stream().filter(post -> post.getId() == id).findAny().orElse(null);
    }

    @Override
    public Post findByTitle(String title) {
        return postList.stream().filter(post -> post.getTitle().equals(title)).findAny().orElse(null);
    }

    @Override
    public List<Post> findAll() {
        return postList;
    }

    @Override
    public boolean containsById(long id) {
        return postList.stream().anyMatch(post -> post.getId() == id);
    }

    @Override
    public boolean containsByTitle(String title) {
        return postList.stream().anyMatch(post -> post.getTitle().equals(title));
    }

    @Override
    public void updateDescription(long id, String description) {
        postList.stream().filter(post -> post.getId() == id).forEach(post -> post.setDescription(description));
    }

    @Override
    public void updateCategory(long id, Category category) {
        postList.stream().filter(post -> post.getId() == id).forEach(post -> post.setCategory(category));
    }


    @Override
    public void updateTag(long id, Tag tag) {
        postList.stream().filter(post -> post.getId() == id).forEach(post -> post.setTag(tag));
    }

}