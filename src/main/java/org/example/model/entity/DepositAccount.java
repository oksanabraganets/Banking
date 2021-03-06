package org.example.model.entity;

public class DepositAccount extends Account {
    private int depositAmount;
    private int depositRate;
    //private List<Transfer> history;

    public int getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(int depositAmount) {
        this.depositAmount = depositAmount;
    }

    public int getDepositRate() {
        return depositRate;
    }

    public void setDepositRate(int depositRate) {
        this.depositRate = depositRate;
    }

    public int getAccrued() {
        return 0;
    }

    public String getType() {
        return "DEPOSIT";
    }

    public int getCreditLimit() {
        return 0;
    }

    public int getAmount() {
        return depositAmount;
    }

    public int getRate() {
        return depositRate;
    }

    public int getDebt(){
        return 0;
    }

    public String toString() {
        return "DepositAccount{" +
                super.toString() +
                ", depositAmount=" + depositAmount +
                ", depositRate=" + depositRate +
                '}';
    }

    public int getAvailableMoney(){
        return  getBalance();
    }
}

