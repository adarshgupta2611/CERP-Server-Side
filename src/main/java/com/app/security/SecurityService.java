package com.app.security;

import com.app.userDetails.AdminUserDetailsService;
import com.app.userDetails.StudentUserDetailsService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityService {

    @Autowired
    private AdminUserDetailsService adminUserDetailsService;

    @Autowired
    private StudentUserDetailsService studentUserDetailsService;

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(@NotNull HttpSecurity http) throws Exception {
//        CSRF disable
        http.csrf(AbstractHttpConfigurer::disable);
        http.authenticationProvider(adminAuthenticationProvider());
        http.authenticationProvider(studentAuthenticationProvider());
//        Request Matching
        http.authorizeHttpRequests(auth->auth.requestMatchers("/signin/**").permitAll());
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();

    }

    public AuthenticationProvider adminAuthenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider(passwordEncoder());
        auth.setUserDetailsService(adminUserDetailsService);
        return auth;
    }
    public AuthenticationProvider studentAuthenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider(passwordEncoder());
        auth.setUserDetailsService(studentUserDetailsService);
        return auth;
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}