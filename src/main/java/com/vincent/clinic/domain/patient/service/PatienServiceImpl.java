package com.vincent.clinic.domain.patient.service;

import com.vincent.clinic.domain.patient.dto.PatientSaveServiceRequest;
import com.vincent.clinic.domain.patient.entity.Patient;
import com.vincent.clinic.domain.patient.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatienServiceImpl implements PatientService {

    private final PatientRepository patientRepo;

    @Override
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
}
