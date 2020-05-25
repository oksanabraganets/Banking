package org.example.model.dao.impl;

import org.example.model.dao.UserDao;
import org.example.model.dao.mapper.AccountMapper;
import org.example.model.dao.mapper.UserMapper;
import org.example.model.entity.Account;
import org.example.model.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUserDao implements UserDao {

    private Connection connection;

    public JDBCUserDao(Connection connection) {
        this.connection = connection;
    }

    public User findByEmailPassword(String email, String pass){
        List<Account> accounts = new ArrayList<>();
        final String query =
                "select * from user left join user_account_link using (iduser) " +
                        "left join account using(idaccount) where email='" + email + "' and password = '" + pass + "'";
        System.out.println(query);
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            System.out.println(rs);
            UserMapper userMapper = new UserMapper();
            AccountMapper accountMapper = new AccountMapper();

            User user = null;
            while (rs.next()) {
                user = userMapper.extractFromResultSet(rs);
                Account account = accountMapper.extractFromResultSet(rs);
                accounts.add(account);
            }
            //TODO check user not null
            user.setAccounts(accounts);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveUser(User entity){
        final String query =
                "insert into user (first_name, last_name, email, password, role, first_name_ua, last_name_ua)" +
                " values ('" +
                    entity.getFirstName() + "', '" +
                    entity.getLastName() + "', '" +
                    entity.getEmail() + "', '" +
                    entity.getPassword() + "', '" +
                    "ROLE_USER', '" +
                    entity.getFirstNameUkr() + "', '" +
                    entity.getLastNameUkr() + "')";

                System.out.println(query);
        try (Statement st = connection.createStatement()) {
            st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet generatedKeys = st.getGeneratedKeys();
            if (generatedKeys.next()) {
                entity.setId(generatedKeys.getInt(1));
            }else{
                throw new RuntimeException("Creating user failed, no ID obtained.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void saveUserAccounts(User entity) {
        for (Account account : entity.getAccounts()) {
            final String query =
                    "insert into user_account_link (iduser, idaccount) values (" +
                            entity.getId() + ", " +
                            account.getId() + ")";
            System.out.println(query);
            try (Statement st = connection.createStatement()) {
                st.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void create(User entity) {

    }

    public User findById(int id) {
        return null;
    }

    public List<User> findAll() {
        return null;
    }

    public void update(User entity) {

    }

    public void delete(int id) {

    }

    public void close() {

    }
}
