package com.vincent.clinic.global.controller;

import com.vincent.clinic.global.annotation.DController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class BaseController {

    public String redirect(String path) {
        return "redirect:" + path;
    }
}
