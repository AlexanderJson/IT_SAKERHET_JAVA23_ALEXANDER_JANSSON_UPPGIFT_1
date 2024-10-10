package org.example.it_sakerhet_java23_alexander_jansson.Controller;

import org.example.it_sakerhet_java23_alexander_jansson.model.Users;
import org.example.it_sakerhet_java23_alexander_jansson.model.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class postUserController {


    private final UsersService service;

    @Autowired
    public postUserController(UsersService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Users user){
        service.registerUser(user.getUsername(), user.getPassword(), user.getEmail(), user.getHometown());
        return ResponseEntity.ok("User registered! ");
    }

    @DeleteMapping("/delete/{username}")
    public ResponseEntity<String> deleteUser(@PathVariable String username){
        boolean deleteSuccess = service.deleteUser(username);
        if(deleteSuccess){
            return ResponseEntity.ok("User deleted!");
        }else {
            return ResponseEntity.ok("Users not found!");
        }
    }

}

