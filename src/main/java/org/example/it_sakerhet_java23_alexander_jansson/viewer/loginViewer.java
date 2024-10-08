package org.example.it_sakerhet_java23_alexander_jansson.viewer;

import org.example.it_sakerhet_java23_alexander_jansson.model.Users;
import org.example.it_sakerhet_java23_alexander_jansson.model.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;

@Component
public class loginViewer {
    Scanner loginSc = new Scanner(System.in);
    LoggedIn auth = LoggedIn.getInstance();

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersService usersService;



    public void login(){


        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();

        Optional<Users> checkLogin = usersService.findUserByUsername(username);
        if (checkLogin.isPresent()) {
            Users user = checkLogin.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                auth.setLoggedIn(true);
                System.out.println("Logged in!");
            }
            else {
                System.out.println("Invalid username or password");
            }
        }else {
            System.out.println("User " + username + " doesnt exist!");
        }

    }
    public void register(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a username: ");
        String username = scanner.nextLine();
        System.out.println("Choose a password: ");
        String password = scanner.nextLine();
        usersService.addNewUser(username,password);
    }

    public void loginMenu(){
        System.out.println("Login menu: 1) LOGIN - 2) REGISTER - 3) EXIT");
        int loginChoice = 0;
        while (loginChoice != 3){
            loginChoice = loginSc.nextInt();
            if (loginChoice == 1){
                login();
            }
            else if (loginChoice == 2){
                register();
            }
            else if (loginChoice == 3){
                System.out.println("Exiting program");
                System.exit(0);
            }
        }


    }
}
