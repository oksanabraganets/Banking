package org.example.model.service;

import org.example.model.entity.CreditAccount;
import org.example.model.entity.DepositAccount;

public class Calculator {

    private static final int HUNDRED_PERCENTS = 100;
    private static final int NUMBER_MONTHS = 12;

    public void calculateCreditInterest(CreditAccount account){
        int accruedInterest = (-account.getBalance() * account.getCreditRate()) / HUNDRED_PERCENTS / NUMBER_MONTHS;
        account.setAccrued(accruedInterest);
        account.setDebt(account.getDebt() + accruedInterest);
    }

    public void calculateDepositInterest(DepositAccount account){
        int accruedInterest = account.getDepositAmount() * account.getDepositRate() / HUNDRED_PERCENTS / NUMBER_MONTHS;
        account.setBalance(account.getBalance() + accruedInterest);
    }
}
