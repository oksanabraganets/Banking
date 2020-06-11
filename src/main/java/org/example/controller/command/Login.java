package org.example.controller.command;

import org.example.model.entity.User;
import org.example.model.service.UserService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.http.HttpServletRequest;

public class Login implements Command {

    UserService userService;
    private static final Logger logger = LogManager.getLogger(Login.class);

    public Login(UserService userService) {
        this.userService = userService;
    }

    public String execute(HttpServletRequest request) {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        if( name == null || name.equals("") || pass == null || pass.equals("")  ){
            return "/login.jsp";
        }
        if(CommandUtility.checkUserIsLogged(request, name)){
            throw new RuntimeException("User " + name + " is logged in already");
        }
        User user = userService.getUserByEmailPassword(name, CommandUtility.hashPassword(pass));
        CommandUtility.setUserRole(request, user);
        if (user.getRole().equals(User.ROLE.ROLE_ADMIN)){
            return "/WEB-INF/admin/adminbasis.jsp";
        } else if(user.getRole().equals(User.ROLE.ROLE_USER)) {
            logger.info("User "+ name+" logged successfully.");
            return "/WEB-INF/user/userbasis.jsp";
        } else {
            user.setRole(User.ROLE.ROLE_UNKNOWN);
            CommandUtility.setUserRole(request, user);
            return "/login.jsp";
        }
    }
}
