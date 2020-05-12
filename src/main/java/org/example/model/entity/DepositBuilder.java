package org.example.model.entity;

import java.sql.Date;

public class DepositBuilder {
    private int i;
    private int b;
    private Date v;
    private int da;
    private int dr;

    public DepositBuilder depositAmount(int da){
        this.da = da;
        return this;
    }
    public DepositBuilder depositRate(int dr){
        this.dr = dr;
        return this;
    }
    public DepositBuilder id( int i){
        this.i = i;
        return this;
    }
    public DepositBuilder validity(Date v){
        this.v = v;
        return this;
    }
    public DepositBuilder balance(int b){
        this.b = b;
        return this;
    }
    public DepositAccount build(){
        DepositAccount account = new DepositAccount();
        account.setId(i);
        account.setBalance(b);
        account.setValidity(v);
        account.setDepositAmount(da);
        account.setDepositRate(dr);
        return account;
    }
}
