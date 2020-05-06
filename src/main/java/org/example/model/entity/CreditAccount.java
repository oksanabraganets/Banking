package org.example.model.entity;

public class CreditAccount extends Account {
    private int creditLimit;
    private int creditRate;
    private int debt;
    private int accrued;

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    public int getCreditRate() {
        return creditRate;
    }

    public void setCreditRate(int creditRate) {
        this.creditRate = creditRate;
    }

    public int getDebt() {
        return debt;
    }

    public void setDebt(int debt) {
        this.debt = debt;
    }

    public int getAccrued() {
        return accrued;
    }

    public void setAccrued(int accrued) {
        this.accrued = accrued;
    }

    public String toString() {
        return "CreditAccount{" +
                super.toString() +
                ", creditLimit=" + creditLimit +
                ", creditRate=" + creditRate +
                ", debt=" + debt +
                ", accrued=" + accrued +
                '}';
    }

    public int getAvailableMoney(){
        return  creditLimit + getBalance();
    }
}
