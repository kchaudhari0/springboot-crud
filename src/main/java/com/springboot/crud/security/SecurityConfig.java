package com.springboot.crud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager()
    {
        UserDetails user1= User.builder()
                .username("user1")
                .password("{noop}password1")
                .roles("EMPLOYEE")
                .build();

        UserDetails user2= User.builder()
                .username("user2")
                .password("{noop}password2")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails user3= User.builder()
                .username("user3")
                .password("{noop}password3")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user1,user2,user3);
    }

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity security) throws Exception{

        security.authorizeHttpRequests(configurer->
                configurer
                        .requestMatchers(HttpMethod.GET,"/service/employees").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET,"/service/employees/**").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.POST,"/service/employees").hasRole("MANAGER")
                .requestMatchers(HttpMethod.PUT,"/service/employees").hasRole("MANAGER")
                .requestMatchers(HttpMethod.DELETE,"/service/employees/**").hasRole("ADMIN")
                );


        security.httpBasic();

        security.csrf().disable();

        return security.build();

    }
}
