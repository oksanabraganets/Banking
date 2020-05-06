package org.example.model.entity;

import java.sql.Date;

public abstract class Account {
    private int id;
    private int balance;
    private Date validity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Date getValidity() {
        return validity;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }

    public String toString() {
        return "id=" + id +
                ", balance=" + balance +
                ", validity=" + validity;
    }

    public abstract int getAvailableMoney();
}
