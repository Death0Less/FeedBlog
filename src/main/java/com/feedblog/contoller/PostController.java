package com.feedblog.contoller;

import com.feedblog.model.Post;
import com.feedblog.model.User;
import com.feedblog.service.CategoryServiceImpl;
import com.feedblog.service.PostServiceImpl;
import com.feedblog.service.TagServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostServiceImpl postService;

    private final TagServiceImpl tagService;

    private final CategoryServiceImpl categoryService;

    public PostController(PostServiceImpl postService, TagServiceImpl tagService, CategoryServiceImpl categoryService) {
        this.postService = postService;
        this.tagService = tagService;
        this.categoryService = categoryService;
    }

    @PostMapping("/save")
    public String save(@RequestParam String description,@RequestParam String title, @RequestParam long categoryId,
                       @RequestParam long tagId, HttpSession httpSession, Model model) {
        Date date = new Date();
        User user = (User) httpSession.getAttribute("user");
        if (postService.add(new Post(title, description, user,
                categoryService.findById(categoryId), tagService.findById(tagId), date))) {
            model.addAttribute("message", "Save is successfully done.");
        } else {
            model.addAttribute("message", "Save is failed");
        }
        return "/posts/save";
    }

    @GetMapping("/save")
    public String save(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("tags", tagService.findAll());
        return "/posts/save";
    }

    @PostMapping("/deleteById")
    public String deleteById(@RequestParam long id, Model model) {
        if (postService.deleteById(id)) {
            model.addAttribute("message", "Delete is successfully done.");
        } else {
            model.addAttribute("message", "Delete is failed");
        }
        return "/posts/deleteById";
    }

    @GetMapping("/deleteById")
    public String deleteById(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "/posts/deleteById";
    }

    @PostMapping("/deleteByTitle")
    public String deleteByTitle(@RequestParam String title, Model model) {
        if (postService.deleteByTitle(title)) {
            model.addAttribute("message", "Delete is successfully done.");
        } else {
            model.addAttribute("message", "Delete is failed.");
        }
        return "/posts/deleteByTitle";
    }

    @GetMapping("/deleteByTitle")
    public String deleteByTitle(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "/posts/deleteByTitle";
    }

    @PostMapping("/findById")
    public String findById(@RequestParam long id, Model model) {
        if (postService.findById(id) == null) {
            model.addAttribute("message", "Post is not found.");
        } else {
            model.addAttribute("post", postService.findById(id));
        }
        return "/posts/findById";
    }

    @GetMapping("/findById")
    public String findById() {
        return "/posts/findById";
    }

    @PostMapping("/findByTitle")
    public String findByTitle(@RequestParam String title, Model model) {
        if (postService.findByTitle(title) == null) {
            model.addAttribute("message", "Post is not found.");
        } else {
            model.addAttribute("post", postService.findByTitle(title));
        }
        return "/posts/findByTitle";
    }

    @GetMapping("/findByTitle")
    public String findByTitle() {
        return "/posts/findByTitle";
    }

    @GetMapping("/findAll")
    public String findAll(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "/posts/findAll";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable long id, @RequestParam String description,
                         @RequestParam long categoryId, @RequestParam long tagId) {
        postService.updateDescription(id, description);
        postService.updateCategory(id, categoryService.findById(categoryId));
        postService.updateTag(id, tagService.findById(tagId));
        return "/posts/update";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable long id, Model model) {
        model.addAttribute("post", postService.findById(id));
        model.addAttribute("tags", tagService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        return "/posts/update";
    }
}
