package org.example.controller.filters;

import java.util.Locale;
import java.util.ResourceBundle;

public class Messages {
    private String name;
    private String login;
    private String registration;
    private String loggingIn;
    private String toHome;
    private String logout;
    private String bill;
    private String transfer;
    private String info;
    private String welcome;
    private String accounts;
    private String id;
    private String balance;
    private String validity;

    public Messages(Locale locale) {
        System.out.println(locale);
        ResourceBundle rb = ResourceBundle.getBundle("messages",locale);
        name = rb.getString("name");
        login = rb.getString("login");
        registration = rb.getString("registration");
        loggingIn = rb.getString("login.name");
        toHome = rb.getString("home");
        welcome = rb.getString("user.welcome");
        accounts = rb.getString("user.accounts");
        info = rb.getString("user.info");
        transfer = rb.getString("user.transfer");
        bill = rb.getString("user.bill");
        logout = rb.getString("logout");
        id = rb.getString("account.id");
        balance = rb.getString("account.balance");
        validity= rb.getString("account.validity");
    }

    public String getId() {
        return id;
    }

    public String getBalance() {
        return balance;
    }

    public String getValidity() {
        return validity;
    }

    public String getLogout() {
        return logout;
    }

    public String getBill() {
        return bill;
    }

    public String getTransfer() {
        return transfer;
    }

    public String getInfo() {
        return info;
    }

    public String getWelcome() {
        return welcome;
    }

    public String getAccounts() {
        return accounts;
    }

    public String getName() {
        return name;
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
