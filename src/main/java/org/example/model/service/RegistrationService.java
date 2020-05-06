package org.example.model.service;

import org.example.model.dao.DaoFactory;
import org.example.model.dao.UserDao;
import org.example.model.entity.User;

public class RegistrationService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    public boolean saveUser(User entity){
        System.out.println("In service: " + entity);
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.saveUser(entity);
        }
    }
}
