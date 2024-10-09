package org.example.it_sakerhet_java23_alexander_jansson.model;

import org.example.it_sakerhet_java23_alexander_jansson.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository usersRepository;


    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users registerUser(String username, String password) {
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(password);
        return usersRepository.save(user);
    }
}