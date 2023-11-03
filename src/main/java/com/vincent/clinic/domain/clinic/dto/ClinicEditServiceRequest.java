package com.vincent.clinic.domain.clinic.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter @Setter
@ToString
public class ClinicEditServiceRequest {

    private Long clinicNo;
    private Long departmentNo;
    private Long patientNo;
    private Integer patientNumber;
    private String patientName;
    private String doctorName;
    private LocalDate clinicDate;
    private String content;

    @Builder
    private ClinicEditServiceRequest(Long clinicNo, Long departmentNo, Long patientNo, Integer patientNumber, String patientName, String doctorName, LocalDate clinicDate, String content) {
        this.clinicNo = clinicNo;
        this.departmentNo = departmentNo;
        this.patientNo = patientNo;
        this.patientNumber = patientNumber;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.clinicDate = clinicDate;
        this.content = content;
    }

    public static ClinicEditServiceRequest of(Long clinicNo, Long departmentNo, Long patientNo, Integer patientNumber, String patientName, String doctorName, LocalDate clinicDate, String content) {
        return ClinicEditServiceRequest.builder()
                .clinicNo(clinicNo)
                .departmentNo(departmentNo)
                .patientNo(patientNo)
                .patientNumber(patientNumber)
                .patientName(patientName)
                .doctorName(doctorName)
                .clinicDate(clinicDate)
                .content(content)
                .build();
    }
}
