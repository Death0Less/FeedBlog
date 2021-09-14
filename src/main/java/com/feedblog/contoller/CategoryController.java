package com.feedblog.contoller;

import com.feedblog.model.Category;
import com.feedblog.service.CategoryServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryServiceImpl categoryService;


    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/save")
    public String saveCategory(@RequestParam String categoryName, Model model) {
        if (categoryService.add(new Category(categoryName))) {
            model.addAttribute("message", "Save is successfully done.");
        } else {
            model.addAttribute("message", "Save is failed.");
        }
        return "/categories/save";
    }

    @GetMapping(path = "/save")
    public String save(){
        return "/categories/save";
    }

    @PostMapping ("/deleteById")
    public String deleteById(@RequestParam long id, Model model) {
        if (categoryService.deleteById(id)) {
            model.addAttribute("message", "DeleteById is successfully done.");
        } else {
            model.addAttribute("message", "DeleteById is failed.");
        }
        return "/categories/deleteById";
    }

    @GetMapping("/deleteById")
    public String deleteById(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "/categories/deleteById";
    }


    @PostMapping("/deleteByTitle")
    public String deleteByTitle(@RequestParam String categoryName, Model model) {
        if (categoryService.deleteByTitle(categoryName)) {
            model.addAttribute("message", "DeleteByTitle is successfully done.");
        } else {
            model.addAttribute("message", "DeleteByTitle is failed.");
        }
        return "/categories/deleteByTitle";
    }

    @GetMapping("/deleteByTitle")
    public String deleteByTitle() {
        return "/categories/deleteByTitle";
    }

    @PostMapping ("/findById")
    public String findById(@RequestParam long id, Model model) {
        if (categoryService.findById(id) == null) {
            model.addAttribute("message", "Category is not found.");
        } else {
            model.addAttribute("category", categoryService.findById(id));
        }
        return "/categories/findById";
    }

    @GetMapping("/findById")
    public String findById() {
        return "/categories/findById";
    }

    @PostMapping("/findByTitle")
    public String findByTitle(@RequestParam String categoryName, Model model) {
        if (categoryService.findByTitle(categoryName) == null) {
            model.addAttribute("message", "Category is not found.");
        } else {
            model.addAttribute("category", categoryService.findByTitle(categoryName));
        }
        return "/categories/findByTitle";
    }

    @GetMapping("/findByTitle")
    public String findByTitle() {
        return "/categories/findByTitle";
    }

    @GetMapping("/findAll")
    public String findAll(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "/categories/findAll";
    }
}
