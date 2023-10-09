package com.vincent.clinic.domain.clinic.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter
@ToString
public class ClinicAcceptRequest {

    @NotNull(message = "과를 선택해주세요.")
    private List<Long> department;
    @NotBlank(message = "환자번호를 입력해주세요.")
    private Integer patientNumber;
    @NotBlank(message = "환자이름을 입력해주세요.")
    private String patientName;

    public ClinicAcceptServiceRequest toServiceRequest() {
        return ClinicAcceptServiceRequest.of(this.department, this.patientNumber, this.patientName);
    }
}
