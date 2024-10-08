package org.example.it_sakerhet_java23_alexander_jansson.viewer;

import java.beans.PropertyChangeSupport;

public class LoggedIn {
    private static LoggedIn instance;
    public Boolean loggedIn = false;
    private final PropertyChangeSupport support;

    private LoggedIn() {
        support = new PropertyChangeSupport(this);

        support.addPropertyChangeListener(e -> {
            Boolean loggedIn = (Boolean) e.getNewValue();
        });
    }

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
        support.firePropertyChange("loggedIn", null, loggedIn);
    }
}
