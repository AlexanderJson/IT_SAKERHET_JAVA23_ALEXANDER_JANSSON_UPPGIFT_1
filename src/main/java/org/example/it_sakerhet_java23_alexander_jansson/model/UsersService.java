package org.example.it_sakerhet_java23_alexander_jansson.model;

import org.example.it_sakerhet_java23_alexander_jansson.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private UsersRepository usersRepository;


    public List<String> getAllUsers() {
        List<Users> userObjects = usersRepository.findAll();
        List<String> userList = new ArrayList<>();
        for(Users user : userObjects) {
            String userData = "USERNAME: " + user.getUsername() + "\n" + "PASSWORD: " + passwordEncoder.encode(user.getPassword());
            userList.add(userData);
        }
        return userList;
    }


    public Optional<Users> findUserByUsername(String username) {
        System.out.println(username);
        return usersRepository.findByUsername(username);
    }

    public void addNewUser(String username, String password) {
        try{
            Users user = new Users();
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode(password));
            usersRepository.save(user);
        }

            catch (DataIntegrityViolationException e){
            System.out.println("Username already exists");

        }

    }

    //använd global session
    public void removeUser(Users user) {
        usersRepository.delete(user);
    }
}
