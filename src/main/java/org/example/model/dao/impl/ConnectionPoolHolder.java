package org.example.model.dao.impl;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

public class ConnectionPoolHolder {
    private static volatile DataSource dataSource;
    public static DataSource getDataSource(){

        if (dataSource == null){
            synchronized (ConnectionPoolHolder.class) {
                if (dataSource == null) {
                    try{
                        Class.forName("com.mysql.cj.jdbc.Driver");
                    }catch(ClassNotFoundException e){
                        e.printStackTrace();
                    }
                    BasicDataSource ds = new BasicDataSource();
                    ds.setUrl("jdbc:mysql://localhost:3306/mydbtest");
                    ds.setUsername("Oksana");
                    ds.setPassword("root");
                    ds.setMinIdle(5);
                    ds.setMaxOpenPreparedStatements(100);
                    dataSource = ds;
                }
            }
        }
        return dataSource;

    }
}
