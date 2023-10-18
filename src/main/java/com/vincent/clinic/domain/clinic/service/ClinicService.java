package com.vincent.clinic.domain.clinic.service;

import com.vincent.clinic.domain.clinic.dto.ClinicAcceptServiceRequest;
import com.vincent.clinic.domain.clinic.dto.ClinicDto;
import com.vincent.clinic.global.model.Paging;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClinicService {

    Paging<ClinicDto> pagingByDepartmentNo(Long departmentNo, Pageable paging);
    void accept(ClinicAcceptServiceRequest serviceRequest);
    void modify();

}
