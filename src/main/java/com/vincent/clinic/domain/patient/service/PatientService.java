package com.vincent.clinic.domain.patient.service;


import com.vincent.clinic.domain.patient.dto.PatientCheckResponse;
import com.vincent.clinic.domain.patient.dto.PatientSaveServiceRequest;
import com.vincent.clinic.domain.patient.entity.Patient;


public interface PatientService {

    Patient save(PatientSaveServiceRequest serviceReqeust);

    PatientCheckResponse checkPatient(Integer patientNumber);
}
