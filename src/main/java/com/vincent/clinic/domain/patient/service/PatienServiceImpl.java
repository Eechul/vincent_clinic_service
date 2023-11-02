package com.vincent.clinic.domain.patient.service;

import com.vincent.clinic.domain.department.exception.NotFoundDepartmentException;
import com.vincent.clinic.domain.patient.dto.PatientCheckResponse;
import com.vincent.clinic.domain.patient.dto.PatientSaveServiceRequest;
import com.vincent.clinic.domain.patient.entity.Patient;
import com.vincent.clinic.domain.patient.exception.NotFoundPatientException;
import com.vincent.clinic.domain.patient.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PatienServiceImpl implements PatientService {

    private final PatientRepository patientRepo;

    @Override
    public Patient findOneOrigin(Long no) {
        return patientRepo.findById(no).orElseThrow(NotFoundPatientException::new);
    }

    @Override
    @Transactional
    public Patient save(PatientSaveServiceRequest serviceReqeust) {
        Optional<Patient> patient = patientRepo.findByNumber(serviceReqeust.getNumber());
        System.out.println(serviceReqeust.getNumber());
        System.out.println(patient.isPresent());
        boolean present = patient.isPresent();
        if (present) { return patient.get(); }

        Patient newPatient = serviceReqeust.toEntity();
        patientRepo.save(newPatient);
        return newPatient;
    }

    @Override
    public PatientCheckResponse checkPatient(Integer patientNumber) {
        Patient patient = patientRepo.findByNumber(patientNumber).orElseThrow(NotFoundPatientException::new);
        return PatientCheckResponse.of(patient.getNumber(), patient.getName());
    }


}
