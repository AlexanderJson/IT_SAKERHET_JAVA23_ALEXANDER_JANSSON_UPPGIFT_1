package org.example.it_sakerhet_java23_alexander_jansson.viewer;

import org.example.it_sakerhet_java23_alexander_jansson.model.LoginService;
import org.example.it_sakerhet_java23_alexander_jansson.model.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class RegisterView {


    private final LoginService loginService;
    private UsersService usersService;


    @Autowired
    public RegisterView(LoginService loginService, UsersService usersService) {
        this.loginService = loginService;
        this.usersService = usersService;
    }


    public void Register(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a username: ");
        String username = scanner.nextLine();
        System.out.println("Choose a password: ");
        String password = scanner.nextLine();
        usersService.addNewUser(username,password);
        loginService.Alert("Registration Successful");
    }

}
