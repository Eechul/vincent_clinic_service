package com.vincent.clinic.global.controller;

import com.vincent.clinic.global.annotation.DController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@DController
@RequestMapping("/")
public class HomeController {

    @GetMapping("")
    public String index() {
        return "redirect:/clinic";
    }
}
