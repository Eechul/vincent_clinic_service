package com.vincent.clinic.domain.clinic.repository;

import com.vincent.clinic.domain.clinic.entity.Clinic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic, Long> {


    List<Clinic> findByDepartmentNo(Long departmentNo, Pageable pageable);

}
