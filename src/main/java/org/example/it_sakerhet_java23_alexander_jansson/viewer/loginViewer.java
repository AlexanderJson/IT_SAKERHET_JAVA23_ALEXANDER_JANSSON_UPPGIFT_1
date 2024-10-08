package org.example.it_sakerhet_java23_alexander_jansson.viewer;

import org.example.it_sakerhet_java23_alexander_jansson.utils.LoggedIn;

import java.util.Scanner;

public class loginViewer {
    Scanner loginSc = new Scanner(System.in);
    LoggedIn auth = LoggedIn.getInstance();
    boolean loggedIn = auth.getLoggedIn();


    public loginViewer(){
    loginMenu();
    }

    public void login(){
        System.out.println("Enter username: ");
        String username = loginSc.nextLine();
        System.out.println("Enter password: ");
        String password = loginSc.nextLine();

    }
    public void register(){
        System.out.println("Choose username: ");
        String username = loginSc.nextLine();
        System.out.println("Choose password: ");
        String password = loginSc.nextLine();
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
