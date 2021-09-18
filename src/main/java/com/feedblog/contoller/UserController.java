package com.feedblog.contoller;

import com.feedblog.model.User;
import com.feedblog.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;


    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public String save(User user, Model model) {
        if (userService.add(user)) {
            model.addAttribute("message", "Save is successfully done.");
        } else {
            model.addAttribute("message", "Save is failed.");
        }
        return "/users/save";
    }

    @GetMapping("/save")
    public String save() {
        return "/users/save";
    }

    @PostMapping("/deleteById")
    public String deleteById(@RequestParam long id, Model model) {
        if (userService.deleteById(id)) {
            model.addAttribute("message", "Delete is successfully done.");
        } else {
            model.addAttribute("message", "Delete is failed");
        }
        return "/users/deleteById";
    }

    @GetMapping("/deleteById")
    public String deleteById(Model model) {
        model.addAttribute("users", userService.findAll());
        return "/users/deleteById";
    }

    @PostMapping("/deleteByName")
    public String deleteByName(@RequestParam String name, Model model) {
        if (userService.deleteByName(name)) {
            model.addAttribute("message", "Delete is successfully done.");
        } else {
            model.addAttribute("message", "Delete is failed.");
        }
        return "/users/deleteByName";
    }

    @GetMapping("/deleteByName")
    public String deleteByName(Model model) {
        model.addAttribute("users", userService.findAll());
        return "/users/deleteByName";
    }

    @PostMapping("/findById")
    public String findById(@RequestParam long id, Model model) {
        if (userService.findById(id) == null) {
            model.addAttribute("message", "User is not found.");
        } else {
            model.addAttribute("user", userService.findById(id));
        }
        return "/users/findById";
    }

    @GetMapping("/findById")
    public String findById() {
        return "/users/findById";
    }

    @PostMapping("/findByName")
    public String findByName(@RequestParam String name, Model model) {
        if (userService.findByName(name) == null) {
            model.addAttribute("message", "User is not found.");
        } else {
            model.addAttribute("user", userService.findByName(name));
        }
        return "/users/findById";
    }

    @GetMapping("/findByName")
    public String findByName() {
        return "/users/findByName";
    }

    @GetMapping("/findAll")
    public String findAll(Model model) {
        model.addAttribute("users", userService.findAll());
        return "/users/findAll";
    }

    @PostMapping("/updateByName")
    public String updateByName(@RequestParam String name, Model model, HttpSession httpSession) {
        User user1 = (User) httpSession.getAttribute("user");
        User user = userService.findById(user1.getId());
        if (user == null) {
            model.addAttribute("message", "User is not found.");
        } else {
            userService.updateByName(user.getId(), name);
            model.addAttribute("message", "Update is successfully done.");
        }
        return "/users/updateByName";
    }

    @GetMapping("/updateByName")
    public String updateByName(Model model) {
        model.addAttribute("users", userService.findAll());
        return "/users/updateByName";
    }

    @PostMapping("/updateByEmail")
    public String updateByEmail(@RequestParam String email, Model model, HttpSession httpSession) {
        User user1 = (User) httpSession.getAttribute("user");
        User user = userService.findById(user1.getId());
        if (user == null) {
            model.addAttribute("message", "User is not found");
        } else {
            userService.updateByEmail(user.getId(),email);
            model.addAttribute("message", "Update is successfully done.");
        }
        return "/users/updateByEmail";
    }

    @GetMapping("/updateByEmail")
    public String updateByEmail(Model model) {
        model.addAttribute("users", userService.findAll());
        return "/users/updateByEmail";
    }

    @PostMapping("/updateByPassword")
    public String updateByPassword(@RequestParam String password, Model model, HttpSession httpSession) {
        User user1 = (User) httpSession.getAttribute("user");
        User user = userService.findById(user1.getId());
        if (user == null) {
            model.addAttribute("message", "User is not found.");
        } else {
            userService.updateByPassword(user.getId(), password);
            model.addAttribute("message", "Update is successfully done.");
        }
        return "/users/updateByPassword";
    }

    @GetMapping("/updateByPassword")
    public String updateByPassword(Model model) {
        model.addAttribute("users", userService.findAll());
        return "/users/updateByPassword";
    }

    @GetMapping("/account")
    public String account(Model model, HttpSession httpSession) {
        model.addAttribute("user", httpSession.getAttribute("user"));
        return "/users/account";
    }

    @GetMapping("/update")
    public String update() {
        return "/users/update";
    }

    @GetMapping("/delete")
    public String delete(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        userService.deleteById(user.getId());
        return "redirect:/logout";
    }
}
