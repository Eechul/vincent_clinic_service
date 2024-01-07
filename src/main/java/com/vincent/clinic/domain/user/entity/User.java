package com.vincent.clinic.domain.user.entity;

import com.vincent.clinic.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

import static jakarta.persistence.GenerationType.IDENTITY;

@Table(name = "VC_USER")
@Entity
@Getter
public class User extends BaseEntity implements Serializable {

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long no;

    @Column(name = "USER_ID", unique = true)
    private String userId;

    @Column(name = "USER_PWD")
    private String userPwd;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ROLE")
    private String role;

    @Column(name = "LAST_LOGIN_AT")
    private LocalDateTime lastLoginAt;

}
