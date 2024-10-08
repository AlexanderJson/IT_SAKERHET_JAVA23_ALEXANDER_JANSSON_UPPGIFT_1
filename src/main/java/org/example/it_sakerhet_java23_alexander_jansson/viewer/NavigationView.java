package org.example.it_sakerhet_java23_alexander_jansson.viewer;

import org.example.it_sakerhet_java23_alexander_jansson.interfaceUI;
import org.example.it_sakerhet_java23_alexander_jansson.model.LoginService;
import org.example.it_sakerhet_java23_alexander_jansson.model.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class NavigationView {

    private final LoginService loginService;
    private final LoginView loginView;
    private UsersService usersService;
    private PasswordEncoder passwordEncoder;
    private RegisterView registerView;

    @Autowired
    public NavigationView(LoginService loginService, UsersService usersService, PasswordEncoder passwordEncoder, LoginView loginView, RegisterView registerView) {
        this.loginService = loginService;
        this.usersService = usersService;
        this.passwordEncoder = passwordEncoder;
        this.loginView = loginView;
        this.registerView = registerView;
    }


    public void showMenu(){
        Scanner loginSc = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("Login menu: 1) LOGIN - 2) REGISTER - 3) EXIT");
        int loginChoice = 0;
        while (loginChoice != 3){
            loginChoice = loginSc.nextInt();
            if (loginChoice == 1){
                loginView.login();
            }
            else if (loginChoice == 2){
                registerView.Register();
            }
            else if (loginChoice == 3){
                loginService.Alert("Exiting program");
                System.exit(0);
            }
    }
}
}
