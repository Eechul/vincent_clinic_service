package com.vincent.clinic.domain.department.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class DepartmentDto {

    private Long no;
    private String name;
    private String description;

    @Builder
    private DepartmentDto(Long no, String name, String description) {
        this.no = no;
        this.name = name;
        this.description = description;
    }

    public static DepartmentDto of(Long no, String name, String description) {
        return DepartmentDto.builder()
                .no(no)
                .name(name)
                .description(description)
                .build();
    }
}
