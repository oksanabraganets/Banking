package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.model.dao.DaoFactory;
import org.example.model.dao.UserDao;
import org.example.model.entity.CreditAccount;
import org.example.model.entity.CreditBuilder;

import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

    private static final String EMAIL_REGEX= "[A-Za-z_.]{1,20}@[A-Za-z.]{1,20}";
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main( String[] args )throws Exception {
//        DaoFactory factory = DaoFactory.getInstance();
//        UserDao dao = factory.createUserDao();
//        System.out.println(dao.findByEmail("oksanaov@gmail"));

        final Pattern p = Pattern.compile("[А-ЯЇІЄҐ][А-Яа-яЇїІіЄєҐґ']{1,20}");
        Matcher m = p.matcher(
                "first_name=Anna&last_name=Braganets&first_name_uk=Анна&last_name_uk=Бублик&email=bublik@net");

        while (m.find()) {
            System.out.println(m.group());
        }

    }
}
