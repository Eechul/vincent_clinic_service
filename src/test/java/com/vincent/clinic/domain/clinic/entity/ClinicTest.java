package com.vincent.clinic.domain.clinic.entity;

import com.vincent.clinic.domain.clinic.dto.ClinicDto;
import com.vincent.clinic.domain.department.entity.Department;
import com.vincent.clinic.domain.patient.entity.Patient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class ClinicTest {

    @DisplayName("진료 Entity에서 진료접수 createAcceptance")
    @Test
    void createAcceptanceTest() {
        // given
        Department internal = Department.create("internal", "내과", "내과 입니다.");
        Patient patient = Patient.create(1, "홍길동");
        Clinic acceptance = Clinic.createAcceptance(internal, patient);

        // when, then
        assertThat(acceptance).isInstanceOf(Clinic.class).isNotNull()
                .extracting("department", "patient", "doctorName", "clinicDate", "content", "otherContent")
                .containsExactly(internal, patient, null, null, null, null);
    }

    @DisplayName("진료 Entity에서 진료접수 수정 modify")
    @Test
    void modifyTest() {
        // given
        Department internal = Department.create("internal", "내과", "내과 입니다.");
        Patient patient = Patient.create(1, "홍길동");
        Clinic acceptance = Clinic.createAcceptance(internal, patient);
        LocalDate now = LocalDate.now();

        // when, then
        Clinic modify = acceptance.modify(patient, internal, "의사이름", now, "진료내용", "진료기타내용");

        assertThat(modify).isInstanceOf(Clinic.class).isNotNull()
                .extracting("department", "patient", "doctorName", "clinicDate", "content", "otherContent")
                .containsExactly(internal, patient, "의사이름", now, "진료내용", "진료기타내용");
    }

    @DisplayName("진료 Entity toDto")
    @Test
    void toDto() {
        // given
        Department internal = Department.create("internal", "내과", "내과 입니다.");
        Patient patient = Patient.create(1, "홍길동");
        Clinic acceptance = Clinic.createAcceptance(internal, patient);
        LocalDate now = LocalDate.now();

        // when, then
        Clinic modify = acceptance.modify(patient, internal, "의사이름", now, "진료내용", "진료기타내용");
        ClinicDto toDto = modify.toDto();
        assertThat(toDto).isInstanceOf(ClinicDto.class).isNotNull()
                .extracting("department", "patient", "doctorName", "clinicDate", "content", "otherContent")
                .containsExactly(toDto.getDepartment(), toDto.getPatient(), "의사이름", now, "진료내용", "진료기타내용");
    }

}
