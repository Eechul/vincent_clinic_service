package com.vincent.clinic.global.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class VincentClinicSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(autz -> autz
                .requestMatchers("/assets/**", "/css/**", "/fonts/**", "/js/**", "/libs/**")
                .permitAll()
        );

        http.authorizeHttpRequests((autz) -> autz
//            .anyRequest().authenticated()
                    .anyRequest().permitAll() // 개발중 이므로, 모든 페이지를 열어둔다.
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/")
                        .failureUrl("/login")
                        .usernameParameter("userId")
                        .passwordParameter("userPwd")
                        .loginProcessingUrl("/login_proc")
                        .successHandler(((request, response, authentication) -> {
                            System.out.println("authentication = " + authentication.getName());
                            response.sendRedirect("/");
                        }))
                        .failureHandler((request, response, exception) -> {
                            System.out.println("exception = " + exception.getMessage());
                            response.sendRedirect("/login");
                        })
                        .permitAll()
                );

        return http.build();
    }

}
