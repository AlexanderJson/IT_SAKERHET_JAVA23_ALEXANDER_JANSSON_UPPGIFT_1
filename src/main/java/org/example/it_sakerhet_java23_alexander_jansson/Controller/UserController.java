package org.example.it_sakerhet_java23_alexander_jansson.Controller;

import org.apache.catalina.User;
import org.example.it_sakerhet_java23_alexander_jansson.model.Users;
import org.example.it_sakerhet_java23_alexander_jansson.model.UsersService;
import org.example.it_sakerhet_java23_alexander_jansson.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController  {


    private final Users users = new Users();
    private final UsersService service;

    @Autowired
    public UserController(UsersService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Users user){
        service.registerUser(user.getUsername(), user.getPassword());
        return ResponseEntity.ok("User registered! ");
    }

    @DeleteMapping("/delete")
    public String deleteUser(){
        return "test";
    }

}

