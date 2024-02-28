package com.example.endPointAuthorizationBasic.configs;

import jakarta.persistence.Column;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import javax.naming.NoPermissionException;
import java.net.http.HttpClient;

@Configuration
public class SecurityConfig {

    @Bean
//    @Order (2)
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin(Customizer.withDefaults()).
                authorizeHttpRequests(authorize-> authorize.requestMatchers("/company/database")
                        .hasAnyAuthority("dbAdmin","security")).authorizeHttpRequests(authorize-> authorize.requestMatchers("/company/office")
                        .hasAnyAuthority("employee"));
//        http.exceptionHandling(e->e.authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login")));
        return http.build();
    }



    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
