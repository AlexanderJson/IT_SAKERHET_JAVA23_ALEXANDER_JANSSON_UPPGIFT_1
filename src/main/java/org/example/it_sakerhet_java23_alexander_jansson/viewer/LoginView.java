package org.example.it_sakerhet_java23_alexander_jansson.viewer;

import org.example.it_sakerhet_java23_alexander_jansson.model.LoginService;
import org.example.it_sakerhet_java23_alexander_jansson.model.Users;
import org.example.it_sakerhet_java23_alexander_jansson.model.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;

@Component
public class LoginView {

    private final LoginService loginService;
    private UsersService usersService;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public LoginView(LoginService loginService, UsersService usersService, PasswordEncoder passwordEncoder) {
        this.loginService = loginService;
        this.usersService = usersService;
        this.passwordEncoder = passwordEncoder;
    }


    public void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();
        Optional<Users> checkLogin = usersService.findUserByUsername(username);
        if (checkLogin.isPresent()) {
            Users user = checkLogin.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                //starta session här
                loginService.Alert("Login successful!");
            }
            else {
                loginService.Alert("Username or password is incorrect!");
            }
        }else {
            loginService.Alert(username + " doesnt exist!");
        }
    }


}
