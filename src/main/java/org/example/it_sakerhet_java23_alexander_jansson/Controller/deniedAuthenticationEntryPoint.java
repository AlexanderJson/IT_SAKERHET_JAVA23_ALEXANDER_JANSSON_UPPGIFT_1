package org.example.it_sakerhet_java23_alexander_jansson.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Component
public class deniedAuthenticationEntryPoint implements AuthenticationEntryPoint {


    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        String loginURL = "http://localhost:8081/login";
        String regURL = "http://localhost:8081/register";
        System.out.println("AUTHENTICATION ERROR: " + authException.getMessage());
        System.out.println("Please log in or register to do this: ");
        System.out.println(regURL + "   " + loginURL);
    }
}
