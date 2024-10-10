package org.example.it_sakerhet_java23_alexander_jansson.model;

import org.example.it_sakerhet_java23_alexander_jansson.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = (usersRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found!")));

        /* atm the boolean values are set to true returning an empty array
           because the fields doesnt exist atm
        */
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                new ArrayList<>()
                );
    }
}
