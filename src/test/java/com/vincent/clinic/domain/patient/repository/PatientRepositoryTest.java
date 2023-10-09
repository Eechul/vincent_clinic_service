package com.vincent.clinic.domain.patient.repository;

import com.vincent.clinic.GenerateIntegrationTest;
import com.vincent.clinic.domain.patient.entity.Patient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PatientRepositoryTest extends GenerateIntegrationTest {

    @Autowired
    private PatientRepository patientRepository;

    @DisplayName("새로운 환자를 생성한다.")
    @Test
    void addPatient() {
        // given, when
        Patient patient = patientRepository.save(Patient.create(10000, "이동철"));

        // then
        assertThat(patient).isNotNull();
        assertThat(patient).extracting("number", "name").contains(10000, "이동철");
    }
}