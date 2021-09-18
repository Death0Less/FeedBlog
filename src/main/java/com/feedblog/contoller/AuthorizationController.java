package com.feedblog.contoller;

import com.feedblog.model.User;
import com.feedblog.service.AuthorizationService;
import com.feedblog.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/authorization")
public class AuthorizationController {

    private final AuthorizationService authorizationService;

    private final UserServiceImpl userService;

    public AuthorizationController(AuthorizationService authorizationService, UserServiceImpl userService) {
        this.authorizationService = authorizationService;
        this.userService = userService;
    }

    @PostMapping
    public String authorize(@RequestParam String name, @RequestParam String password, HttpSession httpSession, Model model) {
        if (authorizationService.authorize(name, password)) {
            User user = userService.findByName(name);
            httpSession.setAttribute("user", user);
            model.addAttribute("message", "Authorization is successfully done.");
        } else {
            model.addAttribute("message", "Authorization is failed.");
        }
        return "/users/authorization";
    }

    @GetMapping
    public String authorize() {
        return "/users/authorization";
    }
}
