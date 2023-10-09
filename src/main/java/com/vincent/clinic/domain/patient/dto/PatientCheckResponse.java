package com.vincent.clinic.domain.patient.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class PatientCheckResponse {

    private Integer number;
    private String name;

    @Builder
    private PatientCheckResponse(Integer number, String name) {
        this.number = number;
        this.name = name;
    }

    public static PatientCheckResponse of(Integer number, String name) {
        return PatientCheckResponse.builder()
                .number(number)
                .name(name)
                .build();
    }



}
