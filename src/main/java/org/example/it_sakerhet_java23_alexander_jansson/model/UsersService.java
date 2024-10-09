package org.example.it_sakerhet_java23_alexander_jansson.model;

import org.example.it_sakerhet_java23_alexander_jansson.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UsersService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.usersRepository = usersRepository;
    }

    public Users registerUser(String username, String password) {
        try{
            String encodedPassword = passwordEncoder.encode(password);
            Users user = new Users(username, encodedPassword);
            return usersRepository.save(user);
            }
        catch (DataIntegrityViolationException e){
            System.out.println("Username already exists");
        }
        //return ett felmeddelande till http ??
        return null;
    }

    public Optional<Users> findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }

    public void deleteUser(Long userId){
        usersRepository.deleteById(userId);
    }
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

}
