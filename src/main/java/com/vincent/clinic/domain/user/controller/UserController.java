package com.vincent.clinic.domain.user.controller;

import com.vincent.clinic.global.annotation.DController;
import com.vincent.clinic.global.controller.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@DController
@RequiredArgsConstructor
public class UserController extends BaseController {

//    private final BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login(Authentication authentication) {
//        System.out.println(passwordEncoder.encode("qwer12@"));
        if (authentication != null && authentication.isAuthenticated()) {
            return redirect("/clinic");
        }

        return "login";
    }

}
