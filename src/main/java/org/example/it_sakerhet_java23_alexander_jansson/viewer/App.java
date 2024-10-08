package org.example.it_sakerhet_java23_alexander_jansson.viewer;

import org.example.it_sakerhet_java23_alexander_jansson.model.LoginService;
import org.example.it_sakerhet_java23_alexander_jansson.model.Users;
import org.example.it_sakerhet_java23_alexander_jansson.model.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class App {

    private final LoginService loginService;
    private UsersService usersService;
    private PasswordEncoder passwordEncoder;
    private RegisterView registerView;
    private NavigationView navigationView;
    private UserDataView userDataView;

    @Autowired
    public App(LoginService loginService, UsersService usersService, PasswordEncoder passwordEncoder, RegisterView registerView, NavigationView navigationView, UserDataView userDataView) {
        this.loginService = loginService;
        this.usersService = usersService;
        this.passwordEncoder = passwordEncoder;
        this.registerView = registerView;
        this.navigationView = navigationView;
        this.userDataView = userDataView;

        userDataView.fetchData();

    }




}
