package org.example.it_sakerhet_java23_alexander_jansson.model;

import org.example.it_sakerhet_java23_alexander_jansson.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public boolean deleteUser(String username) {
        Optional<Users> user = usersRepository.findByUsername(username);
        if (user.isPresent()) {
            usersRepository.delete(user.get());
            return true;
        }else{
            return false;
        }
    }

    public Optional<Users> searchByUsername(String username) {
        return usersRepository.findByUsername(username);
    }
}