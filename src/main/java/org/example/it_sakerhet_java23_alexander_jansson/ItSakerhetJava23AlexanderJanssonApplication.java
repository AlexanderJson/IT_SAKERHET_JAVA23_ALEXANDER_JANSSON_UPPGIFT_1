package org.example.it_sakerhet_java23_alexander_jansson;

import org.example.it_sakerhet_java23_alexander_jansson.repository.UsersService;
import org.example.it_sakerhet_java23_alexander_jansson.viewer.startApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ItSakerhetJava23AlexanderJanssonApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ItSakerhetJava23AlexanderJanssonApplication.class, args);
        UsersService usersService = context.getBean(UsersService.class);

        startApp start = new startApp();




    }

}
