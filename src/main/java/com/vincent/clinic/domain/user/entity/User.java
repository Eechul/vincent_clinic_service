package com.vincent.clinic.domain.user.entity;

import com.vincent.clinic.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Table(name = "VC_USER")
@Entity
@Getter
public class User extends BaseEntity {

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long no;

    private String password;

    private String name;
}
