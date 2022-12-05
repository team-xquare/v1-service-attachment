package com.xquare.v1serviceattachment.config.security

import com.fasterxml.jackson.databind.ObjectMapper
import com.xquare.v1serviceattachment.config.filter.FilterConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val objectMapper: ObjectMapper
) {

    @Bean
    protected fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .formLogin().disable()
            .cors().and()
            .csrf().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        http
            .authorizeRequests()
            .anyRequest().permitAll()
            .and().apply(FilterConfig(objectMapper))

        return http.build()
    }
}
