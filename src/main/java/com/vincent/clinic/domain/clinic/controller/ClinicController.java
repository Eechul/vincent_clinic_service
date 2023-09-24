package com.vincent.clinic.domain.clinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ClinicController {

    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("/clinic/add")
    public String add(Model model) {
        return "add";
    }

    @GetMapping("/clinic/{no}/edit")
    public String edit(
            Model model,
            @PathVariable Long no
    ) {
        model.addAttribute("no", no);
        return "add";
    }
}
