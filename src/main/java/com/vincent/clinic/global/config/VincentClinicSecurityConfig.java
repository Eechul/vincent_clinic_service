package com.vincent.clinic.global.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class VincentClinicSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((autz) -> autz
                .requestMatchers("/assets/**", "/css/**", "/fonts/**", "/js/**", "/libs/**", "/img/**", "/favicon.ico")
                .permitAll()
                .anyRequest().authenticated()
        )
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/")
                        .failureUrl("/login")
                        .usernameParameter("userId")
                        .passwordParameter("userPwd")
                        .loginProcessingUrl("/login_proc")
                        .successHandler(((request, response, authentication) -> {
                            response.sendRedirect("/");
                        }))
                        .failureHandler((request, response, exception) -> {
                            response.sendRedirect("/login");
                        })
                        .permitAll()
                )
                .sessionManagement(session -> session
                        .sessionFixation().changeSessionId()
                        .maximumSessions(-1)
                );

        return http.build();
    }

}
