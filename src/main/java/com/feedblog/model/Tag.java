package com.feedblog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tag {

    private long id;

    private String tagName;

    public Tag(String tagName) {
        this.tagName = tagName;
    }
}
