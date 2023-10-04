package com.vincent.clinic.domain.user.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Table(name = "VC_USER")
@Entity
@Getter
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
