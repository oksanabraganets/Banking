package org.example.controller.command;

import org.example.model.entity.Account;
import org.example.model.entity.User;
import org.example.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class Login implements Command {

    UserService userService;

    public Login(UserService userService) {
        this.userService = userService;
    }


    public String execute(HttpServletRequest request) {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        System.out.println(name + " " + pass);
        if( name == null || name.equals("") || pass == null || pass.equals("")  ){
            return "/login.jsp";
        }

        if(CommandUtility.checkUserIsLogged(request, name)){
            return "/WEB-INF/error.jsp";
        }

        User user = userService.getUserByEmailPassword(name, CommandUtility.hashPassword(pass));
        List<Account> accounts = user.getAccounts();
        System.out.println("User accounts : " + accounts);

        if( user == null ) return "/WEB-INF/error.jsp";

        User.ROLE role = user.getRole();

        if (user.getRole().equals(User.ROLE.ROLE_ADMIN)){
            CommandUtility.setUserRole(request, User.ROLE.ROLE_ADMIN, user);
            return "/WEB-INF/admin/adminbasis.jsp";
        } else if(user.getRole().equals(User.ROLE.ROLE_USER)) {
            CommandUtility.setUserRole(request, User.ROLE.ROLE_USER, user);
            request.setAttribute("accounts" , accounts);

            return "/WEB-INF/user/userbasis.jsp";
        } else {
            CommandUtility.setUserRole(request, User.ROLE.ROLE_UNKNOWN, user);
            return "/login.jsp";
        }

    }
}
