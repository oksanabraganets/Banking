package org.example.controller.command;

import org.example.model.entity.User;
import org.example.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserBasis implements Command {
    UserService userService;

    public UserBasis(UserService userService) {
        this.userService = userService;
    }

    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        User updatedUser = userService.getUserByEmailPassword(
                user.getEmail(),
                user.getPassword());
        session.setAttribute("user", updatedUser);
        return "/WEB-INF/user/userbasis.jsp";
    }
}
