package org.example.it_sakerhet_java23_alexander_jansson;

import org.example.it_sakerhet_java23_alexander_jansson.Controller.UserController;
import org.example.it_sakerhet_java23_alexander_jansson.Viewer.ConsoleApp;
import org.example.it_sakerhet_java23_alexander_jansson.model.Users;
import org.example.it_sakerhet_java23_alexander_jansson.model.UsersService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

@SpringBootApplication
public class ItSakerhetJava23AlexanderJanssonApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        ApplicationContext context = SpringApplication.run(ItSakerhetJava23AlexanderJanssonApplication.class, args);
        ConsoleApp app = context.getBean(ConsoleApp.class);
        app.getMenu();
    }


}
