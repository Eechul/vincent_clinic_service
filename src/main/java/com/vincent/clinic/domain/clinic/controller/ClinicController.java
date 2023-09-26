package com.vincent.clinic.domain.clinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clinic")
public class ClinicController {

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("name", "home");
        return "index";
    }

    @GetMapping("/{no}")
    public String clinicContent(
            @PathVariable Long no,
            Model model
    ) {
        model.addAttribute("name", "home");
        return "index";
    }

    @GetMapping("/search")
    public String search(Model model) {
        model.addAttribute("name", "search");
        return "search";

    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("name", "add");
        return "add";
    }

    @GetMapping("/{no}/edit")
    public String edit(Model model, @PathVariable Long no) {
        model.addAttribute("name", "edit");
        model.addAttribute("no", no);
        return "add";
    }
}
