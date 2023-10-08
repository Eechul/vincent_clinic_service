package com.vincent.clinic.domain.department.service;

import com.vincent.clinic.GenerateIntegrationTest;
import com.vincent.clinic.domain.department.dto.DepartmentDto;
import com.vincent.clinic.domain.department.entity.Department;
import com.vincent.clinic.domain.department.repository.DepartmentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DepartmentServiceImplTest extends GenerateIntegrationTest {

    @Autowired
    private DepartmentRepository departmentRepo;
    @Autowired
    private DepartmentService departmentService;

    @DisplayName("부서 전체 조회")
    @Test
    void findAll() {
        // given
        createDepartments();

        // when
        List<DepartmentDto> departmentDtos = departmentService.findAll();

        // then
        assertThat(departmentDtos).isNotEmpty();
        assertThat(departmentDtos).hasSize(4);

    }

    @DisplayName("부서 path로 조회")
    @Test
    void findOneByPath() {
        // given
        List<Department> departments = createDepartments();

        // when, then
        departments.forEach(department -> {
            DepartmentDto result = departmentService.findOneByPath(department.getPath());
            assertThat(result).isNotNull();
        });
    }

    public List<Department> createDepartments() {
        return departmentRepo.saveAll(departments());
    }

    public List<Department> departments() {
        return Arrays.asList(
                Department.create("internal", "내과", "내과 입니다."),
                Department.create("orthopedics", "정형외과", "정형외과 입니다."),
                Department.create("dentist", "치과", "치과 입니다."),
                Department.create("obstetrics", "산부인과", "산부인과 입니다.")
        );
    }

}