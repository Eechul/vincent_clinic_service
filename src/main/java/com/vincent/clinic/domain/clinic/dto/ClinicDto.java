package com.vincent.clinic.domain.clinic.dto;

import com.vincent.clinic.domain.patient.entity.Patient;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter @Setter
@ToString
public class ClinicDto {

    private Long no;
    private PatientDto patient;
    private String doctorName;
    private LocalDate clinicDate;
    private String content;
    private String otherContent;

    @Builder
    private ClinicDto(Long no, PatientDto patient, String doctorName, LocalDate clinicDate, String content, String otherContent) {
        this.no = no;
        this.patient = patient;
        this.doctorName = doctorName;
        this.clinicDate = clinicDate;
        this.content = content;
        this.otherContent = otherContent;
    }

    public static ClinicDto create(Long no, PatientDto patient, String doctorName, LocalDate clinicDate, String content, String otherContent) {
        return ClinicDto.builder()
                .no(no)
                .patient(patient)
                .doctorName(doctorName)
                .clinicDate(clinicDate)
                .content(content)
                .otherContent(otherContent)
                .build();
    }
}
