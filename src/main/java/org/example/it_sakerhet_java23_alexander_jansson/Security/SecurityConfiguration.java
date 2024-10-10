package org.example.it_sakerhet_java23_alexander_jansson.Security;

import org.example.it_sakerhet_java23_alexander_jansson.model.LoginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration  {


    @Autowired
    private LoginManager loginManager;


    @Bean
    public   SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/register").permitAll()
                        .requestMatchers("/login").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(loginForm -> loginForm.permitAll().defaultSuccessUrl("/homepage"))
                .logout(LogoutConfigurer::permitAll)
                .userDetailsService(loginManager);
        ;

        return http.build();
    }



    @Bean
    public   PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // handles exception of when user is denied access to resource

    }
