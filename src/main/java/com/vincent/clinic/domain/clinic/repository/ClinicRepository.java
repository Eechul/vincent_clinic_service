package com.vincent.clinic.domain.clinic.repository;

import com.vincent.clinic.domain.clinic.entity.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic, Long> {

}
