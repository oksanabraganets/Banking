package org.example.model.service;

import org.example.model.dao.AccountDao;
import org.example.model.dao.DaoFactory;
import org.example.model.dao.UserDao;
import org.example.model.entity.Account;
import org.example.model.entity.User;

public class RegistrationService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    public void saveUser(User entity){
        System.out.println("In service: " + entity);
        try ( UserDao userDao = daoFactory.createUserDao();
             AccountDao accountDao = daoFactory.createAccountDao() ) {
            userDao.saveUser(entity);
            entity.getAccounts().forEach(accountDao::create);
            userDao.saveUserAccounts(entity);
        }
    }
}
