package org.example.it_sakerhet_java23_alexander_jansson;

import org.example.it_sakerhet_java23_alexander_jansson.Viewer.ConsoleApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class ItSakerhetJava23AlexanderJanssonApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        ApplicationContext context = SpringApplication.run(ItSakerhetJava23AlexanderJanssonApplication.class, args);
        ConsoleApp app = context.getBean(ConsoleApp.class);
        app.getMenu();
    }


}
