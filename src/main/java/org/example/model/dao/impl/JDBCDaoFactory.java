package org.example.model.dao.impl;

import org.example.model.dao.AccountDao;
import org.example.model.dao.DaoFactory;
import org.example.model.dao.TransferDao;
import org.example.model.dao.UserDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {

    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    public UserDao createUserDao() {
        return new JDBCUserDao(getConnection());
    }

    public AccountDao createAccountDao() {
        return new JDBCAccountDao(getConnection());
    }

    public TransferDao createTransferDao() {
        return new JDBCTransferDao(getConnection());
    }

    private Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
