package com.vincent.clinic.domain.department.entity;

import com.vincent.clinic.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "VC_DEPARTMENT")
@Getter
@NoArgsConstructor
public class Department extends BaseEntity {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "NO")
    private Long no;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Builder
    private Department(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static Department create(String name, String description) {
        return Department.builder()
                .name(name)
                .description(description)
                .build();
    }
}
