package com.vincent.clinic.domain.clinic.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class PatientDto {

    private Long no;
    private Integer number;
    private String name;

    @Builder
    @QueryProjection
    public PatientDto(Long no, Integer number, String name) {
        this.no = no;
        this.number = number;
        this.name = name;
    }

    public static PatientDto create(Long no, Integer number, String name) {
        return PatientDto.builder()
                .no(no)
                .number(number)
                .name(name)
                .build();
    }

}
