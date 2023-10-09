package com.vincent.clinic.domain.patient.dto;

import com.vincent.clinic.domain.patient.entity.Patient;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class PatientSaveServiceRequest {

    private String number;
    private String name;

    @Builder
    public PatientSaveServiceRequest(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public Patient toEntity() {
        return Patient.create(number, name);
    }
}
