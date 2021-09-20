package com.feedblog.contoller;

import com.feedblog.model.Comment;
import com.feedblog.service.CommentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/comments")
public class CommentController {

    private final CommentServiceImpl commentService;

    public CommentController(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/save")
    public String saveComment(@RequestParam String content) {
        commentService.add(new Comment(content));
        return "/comments/save";
    }

    @GetMapping()
    public String save() {
        return "/comments/save";
    }
}
