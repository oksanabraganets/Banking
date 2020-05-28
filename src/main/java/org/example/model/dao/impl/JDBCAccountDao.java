package org.example.model.dao.impl;

import org.example.model.dao.AccountDao;
import org.example.model.dao.mapper.AccountMapper;
import org.example.model.dao.mapper.UserMapper;
import org.example.model.entity.Account;
import org.example.model.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCAccountDao implements AccountDao {

    private Connection connection;

    public JDBCAccountDao(Connection connection) {
        this.connection = connection;
    }

    public void create(Account entity) {
        final String query =
                "insert into account (balance, validity, rate, accrued, type, credit_limit, amount) values (" +
                        entity.getBalance() + ", '" +
                        entity.getValidity() + "', " +
                        entity.getRate() + ", " +
                        entity.getAccrued() + ", '" +
                        entity.getType() + "', " +
                        entity.getCreditLimit() + ", " +
                        entity.getAmount() + ")";
        System.out.println(query);
        try (Statement st = connection.createStatement()) {
            st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet generatedKeys = st.getGeneratedKeys();
            if (generatedKeys.next()) {
                entity.setId(generatedKeys.getInt(1));
            }else{
                throw new RuntimeException("Creating account failed, no ID obtained.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        final String query = "select * from account";
        List<Account> accounts = new ArrayList<>();
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            AccountMapper accountMapper = new AccountMapper();

            Account account = null;
            while (rs.next()) {
                account = accountMapper.extractFromResultSet(rs);
                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return accounts;
    }

    public void update(Account entity) {
        final String query =
                "update account set balance = " + entity.getBalance() +
                        ", debt = " + entity.getDebt() +
                        ", accrued = " + entity.getAccrued() +
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

    public Connection getConnection() {
        return connection;
    }
}
