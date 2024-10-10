package org.example.it_sakerhet_java23_alexander_jansson.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class accessDeniedController {

    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "Access Denied!";
    }
}
