package com.vincent.clinic.domain.clinic.entity;

import com.vincent.clinic.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@NoArgsConstructor
@Table(name = "VC_CLINIC")
@Entity
public class Clinic extends BaseEntity {

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long no;

    @Column(name = "PATIENT_NUMBER")
    private String patientNumber;

    @Column(name = "PATIENT_NAME")
    private String patientName;

    @Column(name = "DOCTOR_NAME")
    private String doctorName;

    @Column(name = "CLINIC_DATE")
    private LocalDate clinicDate;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "OTHER_CONTENT")
    private String otherContent;

}
