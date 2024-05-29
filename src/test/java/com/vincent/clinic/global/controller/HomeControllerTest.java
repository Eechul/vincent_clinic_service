package com.vincent.clinic.global.controller;

import com.vincent.clinic.domain.department.service.DepartmentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = { HomeController.class })
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    @DisplayName("루트 접근 시, /clinic 로 리다이렉트 한다.")
    @Test
    @WithMockUser
    public void testIndex() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/clinic"));
    }

    @DisplayName("로그인 하지 않고 루트 접근 시, /login 으로 리다이렉트 한다.")
    @Test
    public void testIndexRedirectionLogin() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login"));
    }

}
