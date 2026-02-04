package com.example.demo.Configuration;

import com.example.demo.Security.JwtFilter;
import com.example.demo.Security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    private JwtFilter jwtFilter;
    @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
            http.csrf(csrf->csrf.disable())
                    .authorizeHttpRequests(auth -> auth
                 .requestMatchers(
                         "/TaskApp/auth/**",
                         "/TaskApp/User/**",
                         "/TaskApp/Task/**"
                 ).permitAll()
                 .anyRequest().authenticated()
                    );
         http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
                    return http.build();
     }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
