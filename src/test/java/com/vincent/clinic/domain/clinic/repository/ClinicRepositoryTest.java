package com.vincent.clinic.domain.clinic.repository;

import com.vincent.clinic.GenerateIntegrationTest;
import com.vincent.clinic.domain.clinic.entity.Clinic;
import com.vincent.clinic.domain.department.entity.Department;
import com.vincent.clinic.domain.department.repository.DepartmentRepository;
import com.vincent.clinic.domain.patient.entity.Patient;
import com.vincent.clinic.domain.patient.repository.PatientRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class ClinicRepositoryTest extends GenerateIntegrationTest {

    @Autowired
    private PatientRepository patientRepo;
    @Autowired
    private ClinicRepository clinicRepo;
    @Autowired
    private DepartmentRepository departmentRepo;

    @DisplayName("진료일지의 일부분을 채운다[진료접수에 사용]")
    @Test
    void save() {
        // given
        // 내과, 정형외과 접수
        Optional<Department> internal = departmentRepo.findByPath("internal");
        Optional<Department> orthopedics = departmentRepo.findByPath("orthopedics");
        // 접수 환자
        Patient patient = Patient.create(19999, "김철수");
        createPatient(patient);
        // 진료일지 일부분 작성
        createClinic(Arrays.asList(
                Clinic.createAcceptance(internal.get(), patient),
                Clinic.createAcceptance(orthopedics.get(), patient)
        ));

        // when
        List<Clinic> clinics = clinicRepo.findAll();


        // then
        assertThat(clinics).isNotNull().hasSize(2);
        assertThat(clinics.get(0).getDepartment().getName()).isEqualTo("내과");
        assertThat(clinics.get(0).getPatient().getNumber()).isEqualTo(19999);
        assertThat(clinics.get(0).getPatient().getName()).isEqualTo("김철수");
        assertThat(clinics.get(1).getDepartment().getName()).isEqualTo("정형외과");
        assertThat(clinics.get(1).getPatient().getNumber()).isEqualTo(19999);
        assertThat(clinics.get(1).getPatient().getName()).isEqualTo("김철수");
    }

    public void createClinic(List<Clinic> clinics) {
        clinicRepo.saveAll(clinics);
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

    public void createPatient(Patient patient) {
        patientRepo.save(patient);
    }

}