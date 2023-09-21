package com.vincent.clinic.domain.user.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "USER")
@Getter
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
