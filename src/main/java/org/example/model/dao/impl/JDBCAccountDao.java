package org.example.model.dao.impl;

import org.example.model.dao.AccountDao;
import org.example.model.dao.mapper.AccountMapper;
import org.example.model.dao.mapper.UserMapper;
import org.example.model.entity.Account;
import org.example.model.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class JDBCAccountDao implements AccountDao {

    private Connection connection;

    public JDBCAccountDao(Connection connection) {
        this.connection = connection;
    }

    public void create(Account entity) {

    }

    public Account findById(int id) {
        String query = "select * from account where idaccount = " + id;
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            AccountMapper accountMapper = new AccountMapper();

            Account account = null;
            while (rs.next()) {
                account = accountMapper.extractFromResultSet(rs);
            }
            return account;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Account> findAll() {
        return null;
    }

    public void update(Account entity) {
        final String query =
                "update account set balance = " +
                        entity.getBalance() +
                        " where idaccount = " +
                        entity.getId();
        System.out.println(query);
        try (Statement st = connection.createStatement()) {
            st.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {

    }

    public void close() {

    }
}
