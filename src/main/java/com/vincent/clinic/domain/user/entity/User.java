package com.vincent.clinic.domain.user.entity;

import com.vincent.clinic.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Table(name = "VC_USER")
@Entity
@Getter
public class User extends BaseEntity {

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long no;

    @Column(name = "USER_ID", unique = true)
    private String userId;

    @Column(name = "USER_PWD")
    private String userPwd;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LAST_LOGIN_AT")
    private LocalDateTime lastLoginAt;

    @Column(name = "CREATE_AT")
    private LocalDateTime createAt;
}
