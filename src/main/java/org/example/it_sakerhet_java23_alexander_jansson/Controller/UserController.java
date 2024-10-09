package org.example.it_sakerhet_java23_alexander_jansson.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController  {

    @GetMapping("/test")
    public String test(){
        return "test";
    }

}

