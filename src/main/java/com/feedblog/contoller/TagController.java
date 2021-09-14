package com.feedblog.contoller;

import com.feedblog.model.Tag;
import com.feedblog.service.TagServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tags")
public class TagController {

    private final TagServiceImpl tagService;


    public TagController(TagServiceImpl tagService) {
        this.tagService = tagService;
    }

    @PostMapping("/save")
    public String saveTag(@RequestParam String tagName, Model model) {
        if (tagService.add(new Tag(tagName))) {
            model.addAttribute("message", "Save is successfully done.");
        } else {
            model.addAttribute("message", "Save is failed.");
        }
        return "/tags/save";
    }

    @GetMapping(path = "/save")
    public String save() {
        return "/tags/save";
    }

    @DeleteMapping("/deleteById")
    public String deleteById(@RequestParam long id, Model model) {
        if (tagService.deleteById(id)) {
            model.addAttribute("message", "Delete is successfully done.");
        } else {
            model.addAttribute("message", "Delete is failed.");
        }
        return "/tags/deleteById";
    }

    @GetMapping("/deleteById")
    public String deleteById() {
        return "/tags/deleteById";
    }

    @DeleteMapping("/deleteByName")
    public String deleteByName(@RequestParam String tagName, Model model) {
        if (tagService.deleteByName(tagName)) {
            model.addAttribute("message", "Delete is successfully done.");
        } else {
            model.addAttribute("message", "Delete is failed.");
        }
        return "/tags/deleteByName";
    }

    @GetMapping("/deleteByName")
    public String deleteByName() {
        return "/tags/deleteByName";
    }

    @PostMapping("/findById")
    public String findById(@RequestParam long id, Model model) {
        if (tagService.findById(id) == null) {
            model.addAttribute("message", "Search is failed.");
        } else {
            model.addAttribute("tag", tagService.findById(id));
        }
        return "/tags/findById";
    }

    @GetMapping("/findById")
    public String findById() {
        return "/tags/findById";
    }

    @PostMapping("/findByName")
    public String findByName(@RequestParam String tagName, Model model) {
        if (tagService.findByName(tagName) == null) {
            model.addAttribute("message", "Search is failed.");
        } else {
            model.addAttribute("tag", tagService.findByName(tagName));
        }
        return "/tags/findByName";
    }

    @GetMapping("/findByName")
    public String findName() {
        return "/tags/findByName";
    }

    @GetMapping("/findAll")
    public String findAll(Model model) {
        model.addAttribute("message", tagService.findAll());
        return "/tags/findAll";
    }
}
