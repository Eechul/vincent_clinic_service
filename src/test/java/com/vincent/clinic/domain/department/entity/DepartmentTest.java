package com.vincent.clinic.domain.department.entity;

import com.vincent.clinic.domain.department.dto.DepartmentDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DepartmentTest {

    @DisplayName("부서 Entity Create")
    @Test
    void createDepartments() {
        // given
        Department internal = Department.create("internal", "내과", "내과 입니다.");
        Department orthopedics = Department.create("orthopedics", "정형외과", "정형외과 입니다.");
        Department dentist = Department.create("dentist", "치과", "치과 입니다.");
        Department obstetrics = Department.create("obstetrics", "산부인과", "산부인과 입니다.");

        // when, then
        assertThat(internal).isNotNull().extracting("path", "name", "description")
                .containsExactly("internal", "내과", "내과 입니다.");
        assertThat(orthopedics).isNotNull().extracting("path", "name", "description")
                .containsExactly("orthopedics", "정형외과", "정형외과 입니다.");
        assertThat(dentist).isNotNull().extracting("path", "name", "description")
                .containsExactly("dentist", "치과", "치과 입니다.");
        assertThat(obstetrics).isNotNull().extracting("path", "name", "description")
                .containsExactly("obstetrics", "산부인과", "산부인과 입니다.");
    }

    @DisplayName("부서 Entity To Dto")
    @Test
    void createDepartmentsToDto() {
        // given
        Department internal = Department.create("internal", "내과", "내과 입니다.");
        Department orthopedics = Department.create("orthopedics", "정형외과", "정형외과 입니다.");
        Department dentist = Department.create("dentist", "치과", "치과 입니다.");
        Department obstetrics = Department.create("obstetrics", "산부인과", "산부인과 입니다.");

        // when, then
        assertThat(internal.toDto()).isInstanceOf(DepartmentDto.class).isNotNull().extracting("path", "name", "description")
                .containsExactly("internal", "내과", "내과 입니다.");
        assertThat(orthopedics.toDto()).isInstanceOf(DepartmentDto.class).isNotNull().extracting("path", "name", "description")
                .containsExactly("orthopedics", "정형외과", "정형외과 입니다.");
        assertThat(dentist.toDto()).isInstanceOf(DepartmentDto.class).isNotNull().extracting("path", "name", "description")
                .containsExactly("dentist", "치과", "치과 입니다.");
        assertThat(obstetrics.toDto()).isInstanceOf(DepartmentDto.class).isNotNull().extracting("path", "name", "description")
                .containsExactly("obstetrics", "산부인과", "산부인과 입니다.");
    }
}
