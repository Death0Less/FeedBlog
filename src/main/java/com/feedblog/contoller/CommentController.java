package com.feedblog.contoller;

import com.feedblog.model.Comment;
import com.feedblog.model.Post;
import com.feedblog.model.User;
import com.feedblog.service.CommentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/comments")
public class CommentController {

    private final CommentServiceImpl commentService;

    public CommentController(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/save")
    public String saveComment(@RequestParam String content, Model model) {
        if (commentService.add(new Comment(content))) {
            model.addAttribute("message", "Save is successfully done.");
        } else {
            model.addAttribute("message", "Save is failed");
        }
        return "/comments/save";
    }

    @GetMapping()
    public String save() {
        return "/comments/save";
    }

    @PostMapping("/findById")
    public String findById(@RequestParam long id, Model model) {
        if (commentService.findById(id) == null) {
            model.addAttribute("message", "Comment(s) is not found");
        } else {
            model.addAttribute("comment", commentService.findById(id));
        }
        return "/comments/findById";
    }

    @GetMapping("/findById")
    public String findById() {
        return "/comments/findById";
    }

    @DeleteMapping("/deleteById")
    public String deleteById(@RequestParam long id, Model model) {
        if (commentService.deleteById(id)) {
            model.addAttribute("message", "Delete is successfully done.");
        } else {
            model.addAttribute("message", "Delete is failed");
        }
        return "comments/deleteById";
    }

    @GetMapping("/deleteById")
    public String deleteById() {
        return "comments/deleteById";
    }

    @GetMapping("/findAll")
    public String findAll(Model model) {
        model.addAttribute("message", commentService.findAll());
        return "/comments/findAll";
    }

    @PostMapping("/findAllByUser")
    public String findAllByUser(@RequestParam User user, Model model) {
        List<Comment> allByUser = commentService.findAllByUser(user);
        for (Comment comment : allByUser) {
            if (comment.getUser().getName().equals(user.getName())) {
                model.addAttribute("comments", allByUser);
            } else {
                model.addAttribute("message", "Comment(s) is(are) not found.");
            }
        }
        return "/comments/findAllByUser";
    }

    @GetMapping("/findAllByUser")
    public String findAllByUser() {
        return "/comments/findAllByUser";
    }

    @PostMapping ("/findAllByPost")
    public String findAllByPost(@RequestParam Post post, Model model) {
        List<Comment> allByPost = commentService.findAllByPost(post);
        for (Comment comment : allByPost) {
            if (comment.getPost().getTitle().equals(post.getTitle())) {
                model.addAttribute("comments", allByPost);
            } else {
                model.addAttribute("message", "Comment(s) is(are) not found");
            }
        }
        return "/comments/findAllByPost";
    }

    @GetMapping("/findAllUser")
    public String findAllByPost() {
        return "/comments/findAllByPost";
    }
}
