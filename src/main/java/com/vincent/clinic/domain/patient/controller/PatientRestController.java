package com.vincent.clinic.domain.patient.controller;

import com.vincent.clinic.domain.patient.dto.PatientCheckRequest;
import com.vincent.clinic.domain.patient.dto.PatientCheckResponse;
import com.vincent.clinic.domain.patient.service.PatientService;
import com.vincent.clinic.global.annotation.DRestController;
import com.vincent.clinic.global.model.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Patient", description = "환자에 관한 REST API")
@DRestController
@RequestMapping(value = "/api/v1/patient", consumes = "application/json", produces = "application/json")
@RequiredArgsConstructor
public class PatientRestController {

    private final DepartmentService departmentService;
    private final PatientService patientService;

    @Operation(summary = "환자 접수 전, 기존 환자 체크")
    @PostMapping("/check")
    public ApiResponse<PatientCheckResponse> checkPatient(
            @Valid @RequestBody PatientCheckRequest request
    ) {
        return ApiResponse.ok(patientService.checkPatient(request.getPatientNumber()));
    }

}
