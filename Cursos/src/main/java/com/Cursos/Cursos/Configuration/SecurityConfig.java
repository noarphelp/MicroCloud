package com.Cursos.Cursos.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@EnableWebSecurity
@Configuration
public class SecurityConfig {



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
        http.authorizeHttpRequests(c->c.requestMatchers("/eureka/**").permitAll() // Permite acceso libre a Eureka
                        .requestMatchers(HttpMethod.DELETE ,"/Cursos/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST,"/Cursos/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT,"/Cursos/**").hasRole("ADMIN")
                        .requestMatchers("/usuario/**").hasRole("ADMIN")
                        .anyRequest()
                .authenticated())
                .httpBasic(Customizer.withDefaults())
                .csrf(cr->cr.disable());


        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }

}
