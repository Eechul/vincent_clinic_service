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

    @PostConstruct
    public void init() {
//        departmentRepo.saveAll(
//            Arrays.asList(
//                    Department.create("internal", "내과", "내과 입니다."),
//                    Department.create("orthopedics", "정형외과", "정형외과 입니다."),
//                    Department.create("dentist", "치과", "치과 입니다."),
//                    Department.create("obstetrics", "산부인과", "산부인과 입니다.")
//            )
//        );
    }

    @Override
    public List<DepartmentDto> findAll() {
        List<Department> departments = departmentRepo.findAll();
        if (departments.isEmpty()) {
            throw new NotFoundDepartmentException();
        }
        return departments.stream().map(department ->
            DepartmentDto.of(department.getNo(), department.getPath(), department.getName(), department.getDescription())
        ).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto findOneByPath(String path) {
        Department department = departmentRepo.findByPath(path).orElseThrow(NotFoundDepartmentException::new);
        return DepartmentDto.of(department.getNo(), department.getPath(), department.getName(), department.getDescription());
    }
}
