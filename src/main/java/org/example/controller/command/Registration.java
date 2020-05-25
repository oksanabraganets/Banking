package org.example.controller.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.model.entity.Account;
import org.example.model.entity.DepositBuilder;
import org.example.model.entity.User;
import org.example.model.entity.UserBuilder;
import org.example.model.service.RegistrationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration implements Command {
    private static final String NAME_REGEX = "[A-Z][a-z]{1,20}";
    private static final String EMAIL_REGEX =  "[A-Za-z_.]{1,20}@[A-Za-z.]{1,20}";
    private static final String NAME_UKR = "[А-ЯЇІЄҐ][А-Яа-яЇїІіЄєҐґ']{1,20}";
    RegistrationService registrationService;
    private static final Logger logger = LogManager.getLogger(Registration.class);

    public Registration(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    public String execute(HttpServletRequest request) {
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        HttpSession session = request.getSession();
        session.setAttribute("message", "");

        if (first_name == null) return "/registration.jsp";
        List<String> names = getCyrillicNames(request);
        String first_name_uk = names.get(0);
        String last_name_uk = names.get(1);
        logger.info(first_name_uk + " " + last_name_uk);
        boolean correctInput = first_name.matches(NAME_REGEX) &&
                (last_name != null) && last_name.matches(NAME_REGEX) &&
                (first_name_uk != null) && first_name_uk.matches(NAME_UKR) &&
                (last_name_uk != null) && last_name_uk.matches(NAME_UKR) &&
                (email != null) && email.matches(EMAIL_REGEX) &&
                (pass != null);
        if ( !correctInput ) {
            session.setAttribute("message", "Incorrect input");
            return "/registration.jsp";
        }
        List<Account> accounts = new ArrayList<>();
        accounts.add(new DepositBuilder().build());
        User user = new UserBuilder()
                .firstName(first_name)
                .lastName(last_name)
                .firstNameUkr(first_name_uk)
                .lastNameUkr(last_name_uk)
                .email(email)
                .password(CommandUtility.hashPassword(pass))
                .role(User.ROLE.ROLE_USER)
                .accounts(accounts)
                .build();
        registrationService.saveUser(user);
        session.setAttribute("message", "Successfully signed up");
        return "/registration.jsp";
    }

    private List<String> getCyrillicNames(HttpServletRequest request){
        String query = null;
        try {
            query = URLDecoder.decode(request.getQueryString(), "UTF-8");
        }catch (java.lang.Exception e){
            e.printStackTrace();
        }
        logger.info(query);
        List<String> names = new ArrayList<>();
        final Pattern p = Pattern.compile("[А-ЯЇІЄҐ][А-Яа-яЇїІіЄєҐґ']{1,20}");
        Matcher m = p.matcher(query);
        while (m.find()) {
            names.add(m.group());
        }
        return names;
    }
}
