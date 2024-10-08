package org.example.it_sakerhet_java23_alexander_jansson.viewer;

import org.example.it_sakerhet_java23_alexander_jansson.repository.UsersService;
import org.example.it_sakerhet_java23_alexander_jansson.utils.LoggedIn;

import java.util.Scanner;

public class loginViewer {
    Scanner loginSc = new Scanner(System.in);
    LoggedIn auth = LoggedIn.getInstance();


    private final UsersService usersService;

    public loginViewer(UsersService usersService) {
        this.usersService = usersService;
        loginMenu();
    }

    public void login(){
        System.out.println("Enter username: ");
        String username = loginSc.nextLine();
        System.out.println("Enter password: ");
        String password = loginSc.nextLine();

    }
    public void register(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Register: Please enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();

            usersService.addNewUser(username,password);

    }

    public void loginMenu(){
        System.out.println("Login menu: 1) LOGIN - 2) REGISTER - 3) EXIT");
        int loginChoice = 0;
        while (loginChoice != 3){
            loginChoice = loginSc.nextInt();
            if (loginChoice == 1){
                auth.setLoggedIn(true);
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
