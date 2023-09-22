package com.vincent.clinic.domain.clinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ClinicController {

    @GetMapping("")
    public String index() {
        return "index";
    }
}
