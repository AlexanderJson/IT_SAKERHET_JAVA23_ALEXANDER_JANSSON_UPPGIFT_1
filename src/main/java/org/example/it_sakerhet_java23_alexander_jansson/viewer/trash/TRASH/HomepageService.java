package org.example.it_sakerhet_java23_alexander_jansson.viewer.trash.TRASH;

import org.example.it_sakerhet_java23_alexander_jansson.interfaceUI;
import org.example.it_sakerhet_java23_alexander_jansson.model.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomepageService implements interfaceUI {


    @Autowired
    private UsersService usersService;



    public void showUserTable(String tableHeader, String... fullData){
        table("List of users: ", String.valueOf(usersService.getAllUsers()));
    }


    public void showUserTable() {
        table("List of users: ", String.valueOf(usersService.getAllUsers()));
    }
}
