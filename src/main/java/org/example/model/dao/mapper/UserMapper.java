package org.example.model.dao.mapper;

import org.example.model.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class UserMapper implements ObjectMapper<User> {

    public User extractFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("iduser"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setFirstNameUkr(rs.getString("first_name_ua"));
        user.setLastNameUkr(rs.getString("last_name_ua"));
        user.setEmail(rs.getString("email"));
        user.setRole(User.ROLE.valueOf(rs.getString("role")));
        user.setPassword(rs.getString("password"));
        return user;

    }

    public User makeUnique(Map<Integer, User> cache, User item) {
        return null;
    }

}
