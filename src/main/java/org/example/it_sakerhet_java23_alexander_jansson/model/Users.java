package org.example.it_sakerhet_java23_alexander_jansson.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    private String password;

    public Users() {}

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
