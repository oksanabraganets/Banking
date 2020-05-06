package org.example.controller.exception;

public class AccountNotExist extends RuntimeException {
    public AccountNotExist() {
    }

    public AccountNotExist(String message) {
        super(message);
    }
}
