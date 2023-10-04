package com.vincent.clinic.domain.clinic.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Tag(name = "Clinic", description = "진료에 관한 API")
@RequestMapping("/clinic")
public class ClinicController {

    @Operation(summary = "진료일지 메인 페이지(목록 페이지)")
    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("name", "home");
        return "index";
    }

    @Operation(summary = "진료일지 상세 페이지")
    @GetMapping("/{no}")
    public String clinicContent(
            @PathVariable Long no,
            Model model
    ) {
        model.addAttribute("name", "home");
        return "content";
    }

    @Operation(summary = "진료일지 추가 페이지")
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("name", "add");
        return "add";
    }

    @Operation(summary = "진료일지 수정 페이지")
    @GetMapping("/{no}/edit")
    public String edit(Model model, @PathVariable Long no) {
        model.addAttribute("name", "edit");
        model.addAttribute("no", no);
        return "add";
    }
}
