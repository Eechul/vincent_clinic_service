package com.vincent.clinic.domain.clinic.controller;

import com.vincent.clinic.domain.clinic.service.ClinicService;
import com.vincent.clinic.domain.department.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = { ClinicController.class })
public class ClinicControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DepartmentService departmentService;
    @MockBean
    private ClinicService clinicService;

    @BeforeEach
    void setUp() {
//        INSERT INTO vc_department(description, name, path, created_at) VALUES('내과 입니다.', '내과', 'internal', NOW());
//        INSERT INTO vc_department(description, name, path, created_at) VALUES('정형외과 입니다.', '정형외과', 'orthopedics', NOW());
//        INSERT INTO vc_department(description, name, path, created_at) VALUES('치과 입니다.', '치과', 'dentist', NOW());
//        INSERT INTO vc_department(description, name, path, created_at) VALUES('산부인과 입니다.', '산부인과', 'obstetrics', NOW());
        // setup에서 처음에 과를 등록
    }

    @DisplayName("진료일지 루트 접근 시, /clinic/internal 로 리다이렉트 한다.")
    @Test
    @WithMockUser
    public void testIndex() throws Exception {
        mockMvc.perform(get("/clinic"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/clinic/internal"));
    }

    @DisplayName("과별 진료리스트 페이지에 접근 가능하다.")
    @Test
    @WithMockUser
    public void testClinicDepartment() throws Exception {
        // setup에서 등록한 과들을 검증하자.
        mockMvc.perform(get("/clinic/internal"))
                .andExpect(status().isOk());
    }


    // 추가할 API Test
    // - 진료과 별 진료리스트
    // - 진료 전체검색 결과리스트

}
