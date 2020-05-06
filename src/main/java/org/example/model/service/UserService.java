package org.example.model.service;

import org.example.model.dao.DaoFactory;
import org.example.model.dao.UserDao;
import org.example.model.entity.User;

public class UserService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    public User getUserByEmailPassword(String email, String pass){
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.findByEmailPassword(email, pass);
        }
    }
}
