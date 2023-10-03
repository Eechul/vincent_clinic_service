package com.vincent.clinic.domain.clinic.entity;

import jakarta.persistence.*;
import lombok.Getter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Table(name = "VC_CLINIC")
@Entity
@Getter
public class Clinic {

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;


}
