package com.vincent.clinic.domain.patient.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class PatientCheckRequest {

    @NotNull(message = "환자번호를 입력해주세요.")
    private Integer patientNumber;
}
