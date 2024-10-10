package org.example.it_sakerhet_java23_alexander_jansson.model;

public class UsersDTO {
    private String username;
    private String email;
    private String hometown;


    public UsersDTO(String username, String email, String hometown) {
        this.username = username;
        this.email = email;
        this.hometown = hometown;
    }


    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
