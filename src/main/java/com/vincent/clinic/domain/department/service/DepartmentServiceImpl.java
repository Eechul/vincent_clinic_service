package com.vincent.clinic.domain.department.service;

import com.vincent.clinic.domain.department.dto.DepartmentDto;
import com.vincent.clinic.domain.department.entity.Department;
import com.vincent.clinic.domain.department.exception.NotFoundDepartmentException;
import com.vincent.clinic.domain.department.repository.DepartmentRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepo;

    @Override
    public List<DepartmentDto> findAll() {
        List<Department> departments = departmentRepo.findAll();
        if (departments.isEmpty()) {
            throw new NotFoundDepartmentException();
        }
        return departments.stream().map(department ->
            DepartmentDto.create(department.getNo(), department.getPath(), department.getName(), department.getDescription())
        ).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto findOneByPath(String path) {
        Department department = departmentRepo.findByPath(path).orElseThrow(NotFoundDepartmentException::new);
        return DepartmentDto.create(department.getNo(), department.getPath(), department.getName(), department.getDescription());
    }
}
