package com.feedblog.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/logout")
public class LogoutController {

    @GetMapping
    public String logOut(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }

}

