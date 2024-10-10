package org.example.it_sakerhet_java23_alexander_jansson.Security;

import org.example.it_sakerhet_java23_alexander_jansson.Controller.deniedAuthenticationEntryPoint;
import org.example.it_sakerhet_java23_alexander_jansson.model.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration  {


    @Autowired
    private LoginService loginManager;
    @Autowired
    private deniedAuthenticationEntryPoint accessDenied;

    @Bean
    public   SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        //full access for demo version
                        .anyRequest().permitAll()
                )
                //when authentication added this will handle access denied errors
                .exceptionHandling(deniedEx -> deniedEx.authenticationEntryPoint(accessDenied))

               // .logout(LogoutConfigurer::permitAll)
                // added logic to Spring Securities default login using the
                // UserDetails interface
                .userDetailsService(loginManager);
        ;

        return http.build();
    }



    @Bean
    public   PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    }
