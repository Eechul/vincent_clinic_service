package com.vincent.clinic.domain.department.repository;

import com.vincent.clinic.GenerateIntegrationTest;
import com.vincent.clinic.domain.department.entity.Department;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class DepartmentRepositoryTest extends GenerateIntegrationTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @DisplayName("진료과는 내과, 정형외과, 치과, 산부인과가 있다.")
    @Test
    void findDepartment() {
        // given
        departmentRepository.saveAll(Arrays.asList(
                Department.create("내과", "내과 입니다."),
                Department.create("정형외과", "정형외과 입니다."),
                Department.create("치과", "치과 입니다."),
                Department.create("산부인과", "산부인과 입니다.")
        ));

        // when
        List<Department> departments = departmentRepository.findAll();

        // then
        assertThat(departments).isNotNull().hasSize(4);
    }
}