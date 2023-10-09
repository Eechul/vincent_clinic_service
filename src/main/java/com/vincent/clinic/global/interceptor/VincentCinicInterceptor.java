package com.vincent.clinic.global.interceptor;

import com.vincent.clinic.domain.department.dto.DepartmentDto;
import com.vincent.clinic.domain.department.service.DepartmentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.List;

public class VincentCinicInterceptor implements HandlerInterceptor {

    private DepartmentService departmentService;

    public VincentCinicInterceptor(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        List<DepartmentDto> clinicDepartments = departmentService.findAll();
        request.setAttribute("clinicDepartments", clinicDepartments);
        return true;
    }


}
