package com.vincent.clinic.domain.clinic.dto;

import com.querydsl.core.annotations.QueryProjection;
import com.vincent.clinic.domain.department.dto.DepartmentDto;
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
    private DepartmentDto department;
    private String doctorName;
    private LocalDate clinicDate;
    private String content;
    private String otherContent;


    @Builder
    @QueryProjection
    public ClinicDto(Long no, PatientDto patient, DepartmentDto department, String doctorName, LocalDate clinicDate, String content, String otherContent) {
        this.no = no;
        this.patient = patient;
        this.department = department;
        this.doctorName = doctorName;
        this.clinicDate = clinicDate;
        this.content = content;
        this.otherContent = otherContent;
    }

    public static ClinicDto create(Long no, PatientDto patient, DepartmentDto department, String doctorName, LocalDate clinicDate, String content, String otherContent) {
        return ClinicDto.builder()
                .no(no)
                .patient(patient)
                .department(department)
                .doctorName(doctorName)
                .clinicDate(clinicDate)
                .content(content)
                .otherContent(otherContent)
                .build();
    }
}
