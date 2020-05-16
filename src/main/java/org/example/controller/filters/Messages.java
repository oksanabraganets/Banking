package org.example.controller.filters;

import java.util.Locale;
import java.util.ResourceBundle;

public class Messages {
    private String login;
    private String registration;
    private String loggingIn;
    private String toHome;

    public Messages(Locale locale) {
        System.out.println(locale);
        ResourceBundle rb = ResourceBundle.getBundle("messages",locale);
        login = rb.getString("login");
        registration = rb.getString("registration");
    }

    public String getLogin() {
        return login;
    }

    public String getRegistration() {
        return registration;
    }

    public String getLoggingIn() {
        return loggingIn;
    }

    public String getToHome() {
        return toHome;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "login='" + login + '\'' +
                ", registration='" + registration + '\'' +
                ", loggingIn='" + loggingIn + '\'' +
                ", toHome='" + toHome + '\'' +
                '}';
    }
}
