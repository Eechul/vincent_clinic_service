package com.vincent.clinic.domain.user.controller;

import com.vincent.clinic.global.annotation.DController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@DController
public class UserController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
