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
    void setUp() { }

    @DisplayName("진료일지 루트 접근 시, /clinic/internal 로 리다이렉트 한다.")
    @Test
    @WithMockUser
    public void testIndex() throws Exception {
        mockMvc.perform(get("/clinic"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/clinic/internal"));
    }

    // 테스트 전에 로그인이 완료된 상태여야 함(세션 저장). security test와 결합할 방법 찾아보기

    // 추가할 API Test
    // - 진료과 별 진료리스트
    // - 진료 전체검색 결과리스트
    // - 로그아웃

}