package com.vincent.clinic.domain.patient.controller;

import com.vincent.clinic.domain.department.service.DepartmentService;
import com.vincent.clinic.global.annotation.DController;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Patient", description = "환자에 관한 API")
@DController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {

    private final DepartmentService departmentService;

    @GetMapping("/accept")
    public String accept(Model model) {
        model.addAttribute("name", "patient-accept");
        return "accept";
    }

}
