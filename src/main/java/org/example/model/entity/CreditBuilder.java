package org.example.model.entity;

import java.sql.Date;

public class CreditBuilder {
    private int i;
    private int b;
    private Date v;
    private int l;
    private int r;
    private int d;
    private int a;

    public CreditBuilder id( int i){
        this.i = i;
        return this;
    }
    public CreditBuilder validity(Date v){
        this.v = v;
        return this;
    }
    public CreditBuilder balance(int b){
        this.b = b;
        return this;
    }

    public CreditBuilder creditLimit(int l){
        this.l = l;
        return this;
    }
    public CreditBuilder creditRate(int r){
        this.r = r;
        return this;
    }
    public CreditBuilder debt(int d){
        this.d = d;
        return this;
    }
    public CreditBuilder accrued(int a){
        this.a = a;
        return this;
    }

    public CreditAccount build(){
        CreditAccount account = new CreditAccount();
        account.setId(i);
        account.setBalance(b);
        account.setValidity(v);
        account.setCreditLimit(l);
        account.setCreditRate(r);
        account.setAccrued(a);
        account.setDebt(d);
        return account;
    }

}
