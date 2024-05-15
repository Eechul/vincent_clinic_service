package com.vincent.clinic.domain.patient.entity;

import com.vincent.clinic.domain.clinic.dto.PatientDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PatientTest {

    @DisplayName("환자 Entity Create")
    @Test
    void createPatient() {
        // given
        Patient patient = Patient.create(1, "홍길동");

        // when, then
        assertThat(patient).isNotNull().extracting("number", "name")
                .containsExactly(1, "홍길동");
    }

    @DisplayName("환자 Entity To Dto")
    @Test
    void toDto() {
        // given
        Patient patient = Patient.create(1, "홍길동");

        // when, then
        assertThat(patient.toDto()).isInstanceOf(PatientDto.class).isNotNull().extracting("number", "name")
                .containsExactly(1, "홍길동");
    }
}
