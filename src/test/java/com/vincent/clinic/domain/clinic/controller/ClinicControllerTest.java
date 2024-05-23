package com.vincent.clinic.domain.clinic.controller;

import com.vincent.clinic.domain.clinic.service.ClinicService;
import com.vincent.clinic.domain.department.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
    public void testIndex() throws Exception {
        mockMvc.perform(get("/clinic"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/clinic/internal"));
    }

}
