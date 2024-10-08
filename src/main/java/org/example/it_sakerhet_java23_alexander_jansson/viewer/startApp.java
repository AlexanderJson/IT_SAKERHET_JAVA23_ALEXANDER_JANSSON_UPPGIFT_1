package org.example.it_sakerhet_java23_alexander_jansson.viewer;

import org.example.it_sakerhet_java23_alexander_jansson.repository.UsersService;
import org.example.it_sakerhet_java23_alexander_jansson.utils.LoggedIn;

import java.util.Scanner;

public class startApp {




    LoggedIn auth = LoggedIn.getInstance();
    boolean loggedIn = auth.getLoggedIn();


    private loginViewer loginPage;
    private final homepageViewer homepage = new homepageViewer();
    private final userDataViewer userData = new userDataViewer();
    private final Scanner sc = new Scanner(System.in);

    public startApp(UsersService usersService){
        this.loginPage = new loginViewer(usersService);

        if(loggedIn){
            menuOptions();
        } else {
            loginPage.login();
        }
    }



    private void menuOptions(){
        System.out.println("MENU: 1) HOME - 2) USER SETTINGS - 3) LOG OUT - 4) EXIT");
            int choice = sc.nextInt();
            if(choice == 1){
                homepage.homepage();
            }
            else if(choice == 2){
                userData.userSettings();
            }
            else if(choice == 3){
                loginPage.login();
                auth.setLoggedIn(false);
            }
        }



    }

