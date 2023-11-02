package com.vincent.clinic.domain.clinic.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter @Setter
@ToString
public class ClinicEditRequest {

    private Long clinicNo;
    private Long patientNo;
    private Long patientNumber;
    private String patientName;
    private String doctorName;
    private LocalDate clinicDate;
    private String content;

}
