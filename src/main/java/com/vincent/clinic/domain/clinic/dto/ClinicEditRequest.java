package com.vincent.clinic.domain.clinic.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter @Setter
@ToString
public class ClinicEditRequest {

    private Long clinicNo;
    private Long departmentNo;
    private Long patientNo;
    private Integer patientNumber;
    private String patientName;
    private String doctorName;
    private LocalDate clinicDate;
    private String content;

    public ClinicEditServiceRequest toService() {
        return ClinicEditServiceRequest.of(this.clinicNo, this.departmentNo, this.patientNo, this.patientNumber, this.patientName, this.doctorName, this.clinicDate, this.content);
    }

}
