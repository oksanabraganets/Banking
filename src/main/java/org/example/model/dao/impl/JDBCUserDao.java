package org.example.model.dao.impl;

import org.example.model.dao.UserDao;
import org.example.model.dao.mapper.AccountMapper;
import org.example.model.dao.mapper.UserMapper;
import org.example.model.entity.Account;
import org.example.model.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public boolean saveUser(User entity){
        final String query =
                "insert into user (first_name, last_name, email, password, role) values ('" +
                    entity.getFirstName() + "', '" +
                    entity.getLastName() + "', '" +
                    entity.getEmail() + "', '" +
                    entity.getPassword() + "', '" +
                    "ROLE_USER')";
        System.out.println(query);
        try (Statement st = connection.createStatement()) {
            st.execute(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void create(User entity) {

    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {

    }
}
