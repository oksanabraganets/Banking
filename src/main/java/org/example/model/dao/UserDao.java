package org.example.model.dao;

import org.example.model.entity.User;

public interface UserDao extends GenericDao<User> {

    public User findByEmailPassword(String email, String pass);

    public void saveUser(User entity);
}
