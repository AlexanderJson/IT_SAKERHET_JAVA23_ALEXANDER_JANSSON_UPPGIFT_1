package org.example.it_sakerhet_java23_alexander_jansson.utils;

public class LoggedIn {
    private static LoggedIn instance;
    public Boolean loggedIn = false;

    private LoggedIn() {}

    public static LoggedIn getInstance() {
        if (instance == null) {
            instance = new LoggedIn();
        }
        return instance;
    }

    public Boolean getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
