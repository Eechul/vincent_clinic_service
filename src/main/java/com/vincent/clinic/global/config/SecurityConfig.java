package com.vincent.clinic.global.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((autz) -> autz
                .requestMatchers("/assets/**", "/css/**", "/fonts/**", "/js/**", "/libs/**", "/img/**", "/favicon.ico")
                .permitAll()
                .anyRequest().permitAll()
        )
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/clinic")
                        .failureUrl("/login")
                        .usernameParameter("userId")
                        .passwordParameter("userPwd")
                        .successHandler(((request, response, authentication) -> {
                            response.sendRedirect("/clinic");
                        }))
                        .failureHandler((request, response, exception) -> {
                            response.sendRedirect("/login");
                        })
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .invalidateHttpSession(true)
                        .deleteCookies("SID")
                        .permitAll()
                )
                .sessionManagement(session -> session
                        .sessionFixation().changeSessionId()
                        .maximumSessions(-1)
                );

        return http.build();
    }

}
