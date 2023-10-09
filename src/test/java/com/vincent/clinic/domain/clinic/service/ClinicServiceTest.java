package com.vincent.clinic.domain.clinic.service;

import com.vincent.clinic.GenerateIntegrationTest;
import com.vincent.clinic.domain.clinic.dto.ClinicAcceptServiceRequest;
import com.vincent.clinic.domain.clinic.entity.Clinic;
import com.vincent.clinic.domain.clinic.repository.ClinicRepository;
import com.vincent.clinic.domain.department.entity.Department;
import com.vincent.clinic.domain.department.repository.DepartmentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ClinicServiceTest extends GenerateIntegrationTest {

    @Autowired
    private DepartmentRepository departmentRepo;
    @Autowired
    private ClinicService clinicService;
    @Autowired
    private ClinicRepository clinicRepo;

    @BeforeEach
    void setUp() {
        createDepartments();
    }

    @DisplayName("한 과를 지정해서 진료를 접수할 수 있다.")
    @Test
    void acceptOneDepartment() {
        // given
        ClinicAcceptServiceRequest serviceRequest = ClinicAcceptServiceRequest.builder()
                .department(List.of(1L))
                .patientNumber(19999)
                .patientName("김철수")
                .build();

        // when
        clinicService.accept(serviceRequest);
        List<Clinic> clinics = clinicRepo.findAll();

        // then
        assertThat(clinics).isNotNull().hasSize(1);
        assertThat(clinics.get(0).getPatient()).extracting("number", "name").containsExactly("19999", "김철수");
        assertThat(clinics.get(0).getDepartment()).extracting("no", "name").containsExactly(1L, "내과");

    }

    @DisplayName("두개 이상의 과를 지정해서 진료를 접수할 수 있다.")
    @Test
    void acceptManyDepartment() {
        // given
        ClinicAcceptServiceRequest serviceRequest = ClinicAcceptServiceRequest.builder()
                .department(List.of(1L, 2L))
                .patientNumber(19999)
                .patientName("김철수")
                .build();

        // when
        clinicService.accept(serviceRequest);
        List<Clinic> clinics = clinicRepo.findAll();

        // then
        assertThat(clinics).isNotNull().hasSize(2);
        assertThat(clinics.get(0).getPatient()).extracting("number", "name").containsExactly("19999", "김철수");
        assertThat(clinics.get(0).getDepartment()).extracting("no", "name").containsExactly(1L, "내과");
        assertThat(clinics.get(1).getPatient()).extracting("number", "name").containsExactly("19999", "김철수");
        assertThat(clinics.get(1).getDepartment()).extracting("no", "name").containsExactly(2L, "정형외과");
    }

    public List<Department> departments() {
        return Arrays.asList(
                Department.create("internal", "내과", "내과 입니다."),
                Department.create("orthopedics", "정형외과", "정형외과 입니다."),
                Department.create("dentist", "치과", "치과 입니다."),
                Department.create("obstetrics", "산부인과", "산부인과 입니다.")
        );
    }

    public List<Department> createDepartments() {
        return departmentRepo.saveAll(departments());
    }
}