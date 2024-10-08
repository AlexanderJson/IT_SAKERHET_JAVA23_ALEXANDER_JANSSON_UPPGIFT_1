package org.example.it_sakerhet_java23_alexander_jansson.viewer;

import org.example.it_sakerhet_java23_alexander_jansson.model.LoginService;
import org.example.it_sakerhet_java23_alexander_jansson.model.Users;
import org.example.it_sakerhet_java23_alexander_jansson.model.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserDataView  {

    private final LoginService loginService;
    private UsersService usersService;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public UserDataView(LoginService loginService, UsersService usersService, PasswordEncoder passwordEncoder) {
        this.loginService = loginService;
        this.usersService = usersService;
        this.passwordEncoder = passwordEncoder;
    }

    public void fetchData(){
        //session baserad
        List<String> usersList = usersService.getAllUsers();
        loginService.list("User data",usersList);

    }
    public void removeData(){}

}
