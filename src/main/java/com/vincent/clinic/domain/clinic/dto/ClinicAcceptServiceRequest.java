package com.vincent.clinic.domain.clinic.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter
@ToString
public class ClinicAcceptServiceRequest {

    private List<Long> department;
    private String patientNumber;
    private String patientName;

    @Builder
    private ClinicAcceptServiceRequest(List<Long> department, String patientNumber, String patientName) {
        this.department = department;
        this.patientNumber = patientNumber;
        this.patientName = patientName;
    }

    public static ClinicAcceptServiceRequest of(List<Long> department, String patientNumber, String patientName) {
        return ClinicAcceptServiceRequest.builder()
                .department(department)
                .patientNumber(patientNumber)
                .patientName(patientName)
                .build();
    }
}
