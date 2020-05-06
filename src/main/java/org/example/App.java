package org.example;

import org.example.model.dao.DaoFactory;
import org.example.model.dao.UserDao;
import org.example.model.entity.CreditAccount;
import org.example.model.entity.CreditBuilder;

import java.sql.Date;

public class App {

    private static final String EMAIL_REGEX= "[A-Za-z_.]{1,20}@[A-Za-z.]{1,20}";

    public static void main( String[] args )throws Exception {
//        DaoFactory factory = DaoFactory.getInstance();
//        UserDao dao = factory.createUserDao();
//        System.out.println(dao.findByEmail("oksanaov@gmail"));

        CreditAccount account = new CreditBuilder()
                .id(12)
                .balance(-10000)
                .validity(Date.valueOf("2021-4-26"))
                .creditLimit(30000)
                .creditRate(45)
                .debt(10000)
                .accrued(4500)
                .build();

        System.out.println(account);


    }
}
