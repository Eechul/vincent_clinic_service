package com.vincent.clinic.domain.department.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class DepartmentDto {

    private Long no;
    private String path;
    private String name;
    private String description;

    @Builder
    @QueryProjection
    public DepartmentDto(Long no, String path, String name, String description) {
        this.no = no;
        this.path = path;
        this.name = name;
        this.description = description;
    }

    public static DepartmentDto create(Long no, String path, String name, String description) {
        return DepartmentDto.builder()
                .no(no)
                .path(path)
                .name(name)
                .description(description)
                .build();
    }
}
