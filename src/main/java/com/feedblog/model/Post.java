package com.feedblog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Post {

    private long id;

    private String title;

    private String description;

    private User user;

    private Category category;

    private Tag tag;

    private boolean isChecked;

    private Date date;

    private int countViews;

    public Post(String title, String description, User user, Category category, Tag tag, Date date) {
        this.title = title;
        this.description = description;
        this.user = user;
        this.category = category;
        this.tag = tag;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", user=" + user +
                ", category=" + category +
                ", tag=" + tag +
                ", date=" + date +
                '}';
    }
}
