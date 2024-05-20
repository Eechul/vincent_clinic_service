package com.vincent.clinic.domain.patient.controller;

import com.vincent.clinic.domain.department.service.DepartmentService;
import com.vincent.clinic.global.annotation.DController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Patient", description = "환자에 관한 API")
@DController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {

    @Operation(summary = "환자 접수하기 페이지")
    @GetMapping("/accept")
    public String accept(final Model model) {
        model.addAttribute("name", "patient-accept");
        return "accept";
    }

    @Operation(summary = "환자 접수완료 페이지")
    @GetMapping("/accept/success")
    public String acceptConfirm(final @RequestParam String patientName, final Model model) {
        model.addAttribute("name", "patient-accept");
        model.addAttribute("patientName", patientName);
        return "accept-confirm";
    }

}
