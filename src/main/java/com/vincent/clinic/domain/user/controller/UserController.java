package com.vincent.clinic.domain.user.controller;

import com.vincent.clinic.global.annotation.DController;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;

@DController
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/login")
    public String login(final Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/clinic";
        }
        return "login";
    }

}
