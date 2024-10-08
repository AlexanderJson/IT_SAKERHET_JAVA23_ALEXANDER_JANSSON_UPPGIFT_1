package org.example.it_sakerhet_java23_alexander_jansson.viewer.trash.TRASH;

import org.example.it_sakerhet_java23_alexander_jansson.model.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class HomepageUI {

    Scanner scanner = new Scanner(System.in);
    UsersService usersService = new UsersService();




    @Autowired
    public HomepageUI(UsersService usersService) {
    }



    public void userSettingsView(){
        System.out.println("Welcome to userSettings. 1)HOME - 2)My settings");
        usersService.getAllUsers();
    }

    public void homeView(){
        System.out.println("Welcome to userSettings. 1)HOME - 2)My settings");
    }

    public void navigation(){

        boolean active = true;
        System.out.println("Welcome to homepage. 1)HOME - 2)My settings - 3)Logout");

        while(active){
        int choice = scanner.nextInt();
            switch(choice){
                case 1:
                    homeView();
                    break;
                    case 2:
                        userSettingsView();
                        break;
                        case 3:
                            active = false;
                            break;
            }

        }

    }


    /*public HomepageUI() {
        uiService.navigationMenu("HOME", "BALANCE", "USER SETTINGS", "LOGOUT");
        uiService.textSection("Stycke 1", "Stycke 2");
        uiService.getUsers();
    }*/

}

/*  TO-DO
        System.out.println("GRIT BANK. Welcome (ett namn)");
        System.out.println("MENU: 1) ACCOUNT BALANCE 2)");

        //hämta namn sen / spara i session, komprimera? ?
        //System.out.println("GRIT BANK. Welcome " + name);


        //HÄMTA ALLA TABLES/OBJEKT
        //        System.out.println("MENU: ");
        //        Tables tables = new Tables();
        //        for (i++, i<tables.length){
        //        System.println(i + table)

        /* ide för ny konsol:
        *
        * */
