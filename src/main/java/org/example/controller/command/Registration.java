package org.example.controller.command;

import org.example.model.entity.User;
import org.example.model.entity.UserBuilder;
import org.example.model.service.RegistrationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Registration implements Command {
    private static final String NAME_REGEX = "[A-Z][a-z]{1,20}";
    private static final String EMAIL_REGEX =  "[A-Za-z_.]{1,20}@[A-Za-z.]{1,20}";
    RegistrationService registrationService;

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

        boolean correctInput = first_name.matches(NAME_REGEX) &&
                (last_name != null) && last_name.matches(NAME_REGEX) &&
                (email != null) && email.matches(EMAIL_REGEX) &&
                (pass != null);
        if ( !correctInput ) {
            session.setAttribute("message", "Incorrect input");
            return "/registration.jsp";
        }

        User user = new UserBuilder()
                .firstName(first_name)
                .lastName(last_name)
                .email(email)
                .password(CommandUtility.hashPassword(pass))
                .role(User.ROLE.ROLE_USER)
                .build();

        if (registrationService.saveUser(user))
            session.setAttribute("message", "Successfully signed up");
        else
            session.setAttribute("message", "Entered email already exists");
        return "/registration.jsp";
    }
}
