package com.vincent.clinic.domain.patient.entity;

import com.vincent.clinic.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "VC_PATIENT")
@Getter
@NoArgsConstructor
public class Patient extends BaseEntity {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "NO")
    private Long no;

    @Column(name = "NUMBER", unique = true)
    private String number;

    @Column(name = "NAME")
    private String name;

    @Builder
    private Patient(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public static Patient create(String number, String name) {
        return Patient.builder()
                .number(number)
                .name(name)
                .build();
    }
}
