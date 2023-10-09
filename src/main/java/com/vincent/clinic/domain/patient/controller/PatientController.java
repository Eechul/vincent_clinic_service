package com.vincent.clinic.domain.patient.controller;

import com.vincent.clinic.domain.department.dto.DepartmentDto;
import com.vincent.clinic.domain.department.service.DepartmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Tag(name = "Patient", description = "환자에 관한 API")
@Controller
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/accept")
    public String accept(Model model) {
        model.addAttribute("name", "patient-accept");
        return "accept";
    }

}
