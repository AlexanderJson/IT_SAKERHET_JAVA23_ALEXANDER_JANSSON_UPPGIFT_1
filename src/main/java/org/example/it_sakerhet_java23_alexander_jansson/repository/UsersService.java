package org.example.it_sakerhet_java23_alexander_jansson.repository;

import org.example.it_sakerhet_java23_alexander_jansson.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public List<Users> getAllUsers() {
        List<Users> userList = usersRepository.findAll();
        for(Users user : userList) {
            System.out.println(user.getPassword());
        }
        return userList;
    }

    public void addNewUser() {
    }
}
