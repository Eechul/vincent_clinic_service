package com.vincent.clinic.domain.patient.repository;

import com.vincent.clinic.domain.patient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByNumber(Integer number);
}
