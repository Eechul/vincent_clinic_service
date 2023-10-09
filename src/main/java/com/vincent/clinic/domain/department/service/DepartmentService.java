package com.vincent.clinic.domain.department.service;

import com.vincent.clinic.domain.department.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    List<DepartmentDto> findAll();
    DepartmentDto findOneByPath(String department);

}
