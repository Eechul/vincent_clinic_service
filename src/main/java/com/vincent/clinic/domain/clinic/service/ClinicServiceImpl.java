package com.vincent.clinic.domain.clinic.service;

import com.vincent.clinic.domain.clinic.dto.*;
import com.vincent.clinic.domain.clinic.entity.Clinic;
import com.vincent.clinic.domain.clinic.exception.NotFoundClinicException;
import com.vincent.clinic.domain.clinic.repository.ClinicJpaRepository;
import com.vincent.clinic.domain.clinic.repository.ClinicRepository;
import com.vincent.clinic.domain.department.dto.DepartmentDto;
import com.vincent.clinic.domain.department.entity.Department;
import com.vincent.clinic.domain.department.exception.NotFoundDepartmentException;
import com.vincent.clinic.domain.department.repository.DepartmentRepository;
import com.vincent.clinic.domain.patient.dto.PatientSaveServiceRequest;
import com.vincent.clinic.domain.patient.entity.Patient;
import com.vincent.clinic.domain.patient.service.PatientService;
import com.vincent.clinic.global.model.Paging;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
    private final ClinicJpaRepository clinicJpaRepo;

    @Override
    public Paging<ClinicDto> pagingByDepartmentNo(Long departmentNo, ClinicServiceRequest serviceRequest) {
        Page<ClinicDto> result = clinicJpaRepo.findByDepartmentNo(departmentNo, serviceRequest);
        return new Paging<>(result.getContent(), result.getTotalPages(), result.getTotalElements(), result.getNumber()+1);
    }

    @Override
    public Clinic findOneOrigin(Long no) {
        return clinicRepo.findById(no).orElseThrow(NotFoundClinicException::new);
    }

    @Override
    public ClinicDto findOne(Long no) {
        Clinic clinic = findOneOrigin(no);
        return ClinicDto.create(
                clinic.getNo(),
                clinic.getPatient().toDto(),
                clinic.getDepartment().toDto(),
                clinic.getDoctorName(),
                clinic.getClinicDate(),
                clinic.getContent(),
                clinic.getOtherContent()
        );
    }

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
    @Transactional
    public ClinicDto modify(ClinicEditServiceRequest serviceRequest) {
        Clinic clinic = clinicRepo.findById(serviceRequest.getClinicNo())
                .orElseThrow(NotFoundClinicException::new);
        Patient patient = clinic.getPatient();
        Department department = departmentRepo.findById(serviceRequest.getDepartmentNo())
                .orElseThrow(NotFoundDepartmentException::new);

        patient.modify(serviceRequest.getPatientNumber(), serviceRequest.getPatientName());
        clinic.modify(patient, department, serviceRequest.getDoctorName(),
                serviceRequest.getClinicDate(), serviceRequest.getContent(), "");
        return clinic.toDto();
    }
}
