package com.vincent.clinic.domain.clinic.service;

import com.vincent.clinic.domain.clinic.dto.ClinicAcceptServiceRequest;
import org.springframework.stereotype.Service;

@Service
public interface ClinicService {

//    List<ClinicDto>
    void accept(ClinicAcceptServiceRequest serviceRequest);
    void modify();

}
