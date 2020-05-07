package org.example.model.service;

import org.example.model.entity.CreditAccount;

public class Calculator {
    private static final int HUNDRED_PERCENTS = 100;
    public void calculateCreditInterest(CreditAccount account){
        int accruedInterest = (-account.getBalance() * account.getCreditRate()) / HUNDRED_PERCENTS;
        account.setAccrued(accruedInterest);
        account.setDebt(account.getDebt() + accruedInterest);
    }
}
