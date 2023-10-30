package com.vincent.clinic.domain.clinic.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.vincent.clinic.domain.clinic.dto.ClinicServiceRequest;
import com.vincent.clinic.domain.clinic.entity.Clinic;
import com.vincent.clinic.domain.clinic.entity.QClinic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.vincent.clinic.domain.clinic.entity.QClinic.clinic;

@Repository
@RequiredArgsConstructor
public class ClinicJpaRepository {

    private final JPAQueryFactory factory;

    public void findByDepartmentNo(Long departmentNo, ClinicServiceRequest serviceRequest) {
        factory.select(clinic)
                .from(clinic)
                .where(clinic.department.no.eq(departmentNo))
                .offset(serviceRequest.getPageRequest().getOffset())
                .limit(serviceRequest.getPageRequest().getPageSize());

    }
}
