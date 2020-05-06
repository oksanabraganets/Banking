package org.example.controller.command;

import javax.servlet.http.HttpServletRequest;

public class UserBasis implements Command {

    public String execute(HttpServletRequest request) {
        return "/WEB-INF/user/userbasis.jsp";
    }
}
