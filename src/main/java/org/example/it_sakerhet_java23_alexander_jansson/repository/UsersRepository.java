package org.example.it_sakerhet_java23_alexander_jansson.repository;

import jakarta.persistence.Table;
import org.example.it_sakerhet_java23_alexander_jansson.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {}
