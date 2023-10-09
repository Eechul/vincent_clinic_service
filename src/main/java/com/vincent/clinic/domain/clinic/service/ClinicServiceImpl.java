package com.vincent.clinic.domain.clinic.service;

import com.vincent.clinic.domain.clinic.dto.ClinicAcceptServiceRequest;
import com.vincent.clinic.domain.clinic.entity.Clinic;
import com.vincent.clinic.domain.clinic.repository.ClinicRepository;
import com.vincent.clinic.domain.department.entity.Department;
import com.vincent.clinic.domain.department.exception.NotFoundDepartmentException;
import com.vincent.clinic.domain.department.repository.DepartmentRepository;
import com.vincent.clinic.domain.patient.dto.PatientSaveServiceRequest;
import com.vincent.clinic.domain.patient.entity.Patient;
import com.vincent.clinic.domain.patient.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ClinicServiceImpl implements ClinicService {

    private final DepartmentRepository departmentRepo;
    private final PatientService patientService;
    private final ClinicRepository clinicRepo;

    @Override
    @Transactional
    public void accept(ClinicAcceptServiceRequest serviceRequest) {
        List<Department> departments = departmentRepo.findAllById(serviceRequest.getDepartment());
        if (departments.isEmpty()) { throw new NotFoundDepartmentException(); }

        Patient patient = patientService.save(
            PatientSaveServiceRequest.builder()
                .number(serviceRequest.getPatientNumber())
                .name(serviceRequest.getPatientName())
                .build()
        );
        departments.forEach(department -> {
            clinicRepo.save(Clinic.createAcceptance(department, patient));
        });
    }

    @Override
    public void modify() {

    }
}
