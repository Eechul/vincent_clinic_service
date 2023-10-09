package com.vincent.clinic.domain.patient.controller;

import com.vincent.clinic.domain.department.service.DepartmentService;
import com.vincent.clinic.domain.patient.dto.PatientCheckResponse;
import com.vincent.clinic.domain.patient.service.PatientService;
import com.vincent.clinic.global.model.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Patient", description = "환자에 관한 REST API")
@RestController
@RequestMapping("/api/v1/patient")
@RequiredArgsConstructor
public class PatientRestController {

    private final DepartmentService departmentService;
    private final PatientService patientService;

    @Operation(summary = "환자 접수 전, 기존 환자 체크")
    @PostMapping("/check")
    public ApiResponse<PatientCheckResponse> checkPatient(
            @RequestParam Integer patientNumber
    ) {
        return ApiResponse.ok(patientService.checkPatient(patientNumber));
    }

}
