package org.example.model.service;

import org.example.model.dao.AccountDao;
import org.example.model.dao.DaoFactory;
import org.example.model.entity.Account;

import java.util.List;

public class AdminService {

    Calculator calculator = new Calculator();

    DaoFactory daoFactory = DaoFactory.getInstance();

    public void accrueAllInterests(){
        try (AccountDao dao = daoFactory.createAccountDao()) {
            List<Account> accounts = dao.findAll();
            accounts.forEach(calculator::calculateInterest);
            accounts.forEach(System.out::println);
            accounts.forEach(dao::update);
        }
    }

}
