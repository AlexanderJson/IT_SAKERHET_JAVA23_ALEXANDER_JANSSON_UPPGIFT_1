package org.example.it_sakerhet_java23_alexander_jansson.Controller;

import org.example.it_sakerhet_java23_alexander_jansson.model.Users;
import org.example.it_sakerhet_java23_alexander_jansson.model.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class getUserController {

    private final Users users = new Users();
    private final UsersService service;


    public getUserController(UsersService service) {
        this.service = service;
    }

    @GetMapping("/search/{username}")
    public ResponseEntity<Users> search(@PathVariable String username) {
        Optional<Users> foundUser = service.searchByUsername(username);
        return foundUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
