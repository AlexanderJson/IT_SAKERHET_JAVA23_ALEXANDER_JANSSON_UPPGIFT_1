package org.example.it_sakerhet_java23_alexander_jansson.viewer.trash.TRASH;

import org.example.it_sakerhet_java23_alexander_jansson.interfaceUI;
import org.example.it_sakerhet_java23_alexander_jansson.model.UsersService;

import java.util.ArrayList;
import java.util.List;

public class UIService implements interfaceUI {

    UsersService usersService = new UsersService();


    public List<String> getUsers(){
        List<String> users = new ArrayList<>();
        usersService.getAllUsers().toArray(users.toArray());
        return users;
    }


    @Override
    public void navigationMenu(String... buttons) {
        interfaceUI.super.navigationMenu(buttons);
    }
}