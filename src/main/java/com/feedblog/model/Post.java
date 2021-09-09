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

}
