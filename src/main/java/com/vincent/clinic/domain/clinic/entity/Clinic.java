package com.vincent.clinic.domain.clinic.entity;

import com.vincent.clinic.domain.department.entity.Department;
import com.vincent.clinic.domain.patient.entity.Patient;
import com.vincent.clinic.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "VC_CLINIC")
@Getter
@NoArgsConstructor
public class Clinic extends BaseEntity {

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long no;

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_NO")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "PATIENT_NO")
    private Patient patient;

    @Column(name = "DOCTOR_NAME")
    private String doctorName;

    @Column(name = "CLINIC_DATE")
    private LocalDate clinicDate;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "OTHER_CONTENT")
    private String otherContent;

    @Builder
    private Clinic(Department department, Patient patient) {
        this.department = department;
        this.patient = patient;
    }

    public static Clinic createAcceptance(Department department, Patient patient) {
        return Clinic.builder()
                .department(department)
                .patient(patient)
                .build();
    }
}
