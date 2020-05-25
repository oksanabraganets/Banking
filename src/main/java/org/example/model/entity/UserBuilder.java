package org.example.model.entity;

import java.util.List;

public class UserBuilder {
    private int i;
    private String f;
    private String l;
    private String e;
    private String p;
    private User.ROLE r;
    private String fu;
    private String lu;
    List<Account> a;

    public UserBuilder accounts(List<Account> a){
        this.a = a;
        return this;
    }

    public UserBuilder firstNameUkr(String fu){
        this.fu = fu;
        return this;
    }

    public UserBuilder lastNameUkr(String lu){
        this.lu = lu;
        return this;
    }

    public UserBuilder id(int i){
        this.i = i;
        return this;
    }

    public UserBuilder firstName(String f){
        this.f = f;
        return this;
    }

    public UserBuilder lastName(String l){
        this.l = l;
        return this;
    }
    public UserBuilder email(String e){
        this.e = e;
        return this;
    }
    public UserBuilder password(String p){
        this.p = p;
        return this;
    }
    public UserBuilder role(User.ROLE r){
        this.r = r;
        return this;
    }

    public User build(){
        User user = new User();
        user.setPassword(p);
        user.setLastName(l);
        user.setFirstName(f);
        user.setLastNameUkr(lu);
        user.setFirstNameUkr(fu);
        user.setEmail(e);
        user.setId(i);
        user.setRole(r);
        user.setAccounts(a);
        return user;
    }
}
