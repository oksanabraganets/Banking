package org.example.model.dao;

import org.example.model.entity.Account;

import java.sql.Connection;
import java.util.List;

public interface AccountDao extends GenericDao<Account> {

    public Connection getConnection();

}
