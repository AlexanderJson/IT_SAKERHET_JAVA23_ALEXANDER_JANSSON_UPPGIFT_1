package org.example.it_sakerhet_java23_alexander_jansson.Viewer;

import org.example.it_sakerhet_java23_alexander_jansson.model.Users;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;


@Component
public class ConsoleApp {
    private  Scanner scanner = new Scanner(System.in);
    private final Users users = new Users();
    private RestTemplate restTemplate;
    public ConsoleApp() {
        this.restTemplate = new RestTemplate();
    }



    public void registerUser(){

        System.out.println("Enter Username: ");
        String username = scanner.next();
        System.out.println("Enter Password: ");
        String password = scanner.next();

        Users user = new Users();
        user.setUsername(username);
        user.setPassword(password);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Users> req = new HttpEntity<>(user, headers);

        String resp = restTemplate.postForObject("http://localhost:8081/register", req, String.class);
        System.out.println(resp);
    }


    public void getMenu(){
        System.out.println("Choose option: ");
        System.out.println("1) Register  -  2) Delete  -  3) Search user");
        int option = scanner.nextInt();
        switch(option){
            case 1:
                registerUser();
                break;
                case 2:
                    deleteUser();
                    break;
                case 3:
                    SearchByUsername();
        }
    }




    public void deleteUser(){
        scanner = new Scanner(System.in);
        System.out.println("Enter Username: ");
        String username = scanner.next();
        /*System.out.println("Enter Password to delete: ");
        String password = scanner.next();*/
        restTemplate.delete("http://localhost:8081/delete/" + username);
        System.out.println(username + " deleted");

    }

    public void SearchByUsername(){
        scanner = new Scanner(System.in);
        System.out.println("Enter Username: ");
        String username = scanner.next();

        try{
            Users user = restTemplate.getForObject("http://localhost:8081/search/" + username, Users.class);
            System.out.println("Found user: " + user.getUsername());
        }catch (Exception e){
            System.out.println(username + " not found");
        }
    }




}
