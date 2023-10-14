package com.vincent.clinic.domain.clinic.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter @Setter
@ToString
public class ClinicDto {

    private Long no;
    private Long patientNo;
    private String patientName;
    private String doctorName;
    private LocalDate clinicDate;
    private String content;
    private String otherContent;

    @Builder
    private ClinicDto(Long no, Long patientNo, String patientName, String doctorName, LocalDate clinicDate, String content, String otherContent) {
        this.no = no;
        this.patientNo = patientNo;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.clinicDate = clinicDate;
        this.content = content;
        this.otherContent = otherContent;
    }

    public static ClinicDto create(Long no, Long patientNo, String patientName, String doctorName, LocalDate clinicDate, String content, String otherContent) {
        return ClinicDto.builder()
                .no(no)
                .patientNo(patientNo)
                .patientName(patientName)
                .doctorName(doctorName)
                .clinicDate(clinicDate)
                .content(content)
                .otherContent(otherContent)
                .build();
    }
}
