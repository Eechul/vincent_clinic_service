package com.vincent.clinic.domain.clinic.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.vincent.clinic.domain.clinic.dto.*;
import com.vincent.clinic.domain.department.dto.QDepartmentDto;
import com.vincent.clinic.global.model.SearchQ;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import static com.vincent.clinic.domain.clinic.entity.QClinic.clinic;

@Repository
@RequiredArgsConstructor
public class ClinicJpaRepository {

    private final JPAQueryFactory jpaQueryfactory;

    public Page<ClinicDto> findBy(Long departmentNo, ClinicServiceRequest serviceRequest) {
        List<ClinicDto> datas = jpaQueryfactory.select(
                        new QClinicDto(
                                clinic.no,
                                new QPatientDto(clinic.patient.no, clinic.patient.number, clinic.patient.name),
                                new QDepartmentDto(
                                    clinic.department.no, clinic.department.path,
                                    clinic.department.name, clinic.department.description
                                ),
                                clinic.doctorName,
                                clinic.clinicDate,
                                clinic.content,
                                clinic.otherContent
                        )
                )
                .from(clinic)
                .where(
                    isEqConditionByDepartmentNo(departmentNo),
                    switchColumnQ(serviceRequest.getSearch())
                )
                .orderBy(clinic.no.desc())
                .offset(serviceRequest.getPageRequest().getOffset())
                .limit(serviceRequest.getPageRequest().getPageSize())
                .fetch();

        Long count = jpaQueryfactory.select(clinic.count())
                .from(clinic)
                .where(
                    isEqConditionByDepartmentNo(departmentNo),
                    switchColumnQ(serviceRequest.getSearch())
                )
                .fetchOne();

        return new PageImpl<>(datas, serviceRequest.getPageRequest(), count);
    }

    private BooleanExpression isEqConditionByDepartmentNo(Long departmentNo) {
        if (departmentNo == null) { return null; }
        return clinic.department.no.eq(departmentNo);
    }

    private BooleanExpression switchColumnQ(SearchQ searchQ) {
        if (searchQ.getCol() == null || searchQ.getCol().isEmpty() ) { return null; }
        switch (searchQ.getCol()) {
            case "patientNumber" -> {
                try {
                    return clinic.patient.number.eq(Integer.parseInt(searchQ.getQ()));
                } catch (NumberFormatException e) {
                    return null;
                }
            }
            case "patientName" -> {
                return clinic.patient.name.contains(searchQ.getQ());
            }
            case "doctorName" -> {
                return clinic.doctorName.contains(searchQ.getQ());
            }
            case "clinicDate" -> {
                try {
                    return clinic.clinicDate.eq(LocalDate.parse(searchQ.getQ(), DateTimeFormatter.ISO_DATE));
                } catch (DateTimeParseException e) {
                    return null;
                }
            }
            case "content" -> {
                return clinic.content.contains(searchQ.getQ());
            }
            case "otherContent" -> {
                return clinic.otherContent.contains(searchQ.getQ());
            }
            default -> {
                return null;
            }
        }
    }
}
