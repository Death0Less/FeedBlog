package com.feedblog.contoller;

import com.feedblog.model.User;
import com.feedblog.service.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public String register(User user, Model model) {
        if (registrationService.registrate(user)) {
            model.addAttribute("message", "Registration is successfully done.");
        } else {
            model.addAttribute("message", "Registration is failed.");
        }
        return "users/registration";
    }

    @GetMapping
    public String register() {
        return "/users/registration";
    }
}
