package org.example.model.dao.impl;

import org.example.model.dao.TransferDao;
import org.example.model.entity.TransferData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class JDBCTransferDao implements TransferDao {

    private Connection connection;

    public JDBCTransferDao(Connection connection) {
        this.connection = connection;
    }

    public void create(TransferData entity) {
        final String query =
                "insert into transfer (source_id, dest_id, amount, date, type) values (" +
                        entity.getSourceId() + ", " +
                        entity.getDestId() + ", " +
                        entity.getAmount() + ", '" +
                        entity.getDate() + "', '" +
                        entity.getType() + "')";
        System.out.println(query);
        try (Statement st = connection.createStatement()) {
            int rows = st.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public TransferData findById(int id) {
        return null;
    }

    public List<TransferData> findAll() {
        return null;
    }

    public void update(TransferData entity) {

    }

    public void delete(int id) {

    }

    public void close() {

    }
}
