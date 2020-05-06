package org.example.controller.exception;

public class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException() {
        super("Not enough money on account");
    }

    public NotEnoughMoneyException(String message) {
        super(message);
    }
}
