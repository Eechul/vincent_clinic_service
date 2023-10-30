package com.vincent.clinic.domain.clinic.service;

import com.vincent.clinic.domain.clinic.dto.ClinicAcceptServiceRequest;
import com.vincent.clinic.domain.clinic.dto.ClinicDto;
import com.vincent.clinic.domain.clinic.dto.ClinicServiceRequest;
import com.vincent.clinic.domain.clinic.dto.PatientDto;
import com.vincent.clinic.domain.clinic.entity.Clinic;
import com.vincent.clinic.domain.clinic.exception.NotFoundClinicException;
import com.vincent.clinic.domain.clinic.repository.ClinicJpaRepository;
import com.vincent.clinic.domain.clinic.repository.ClinicRepository;
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
    public ClinicDto findOne(Long no) {
        Clinic result = clinicRepo.findById(no)
                .orElseThrow(NotFoundClinicException::new);
        return ClinicDto.create(
                result.getNo(),
                PatientDto.create(
                    result.getPatient().getNo(),
                    result.getPatient().getNumber(),
                    result.getPatient().getName())
                ,
                result.getDoctorName(),
                result.getClinicDate(),
                result.getContent(),
                result.getOtherContent()
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
    public void modify() {

    }
}
