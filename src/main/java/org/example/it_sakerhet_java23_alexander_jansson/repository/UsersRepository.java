package org.example.it_sakerhet_java23_alexander_jansson.repository;

import org.example.it_sakerhet_java23_alexander_jansson.model.Users;
import org.example.it_sakerhet_java23_alexander_jansson.model.UsersDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByUsername(String username);

    @Query("SELECT new org.example.it_sakerhet_java23_alexander_jansson.model.UsersDTO(u.username) FROM Users u WHERE u.username = :username")
    Optional<UsersDTO> findByUsernameDTO(@Param("username") String username);
}
