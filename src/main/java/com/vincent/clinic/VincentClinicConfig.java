package com.vincent.clinic;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.vincent.clinic.domain.department.service.DepartmentService;
import com.vincent.clinic.global.interceptor.VincentCinicInterceptor;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableJpaAuditing
@RequiredArgsConstructor
public class VincentClinicConfig implements WebMvcConfigurer {

    private final DepartmentService departmentService;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new VincentCinicInterceptor(departmentService))
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/static/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/static/**").resourceChain(true);
    }

    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager em) {
        return new JPAQueryFactory(em);
    }

}
