package org.example.controller.command;

import org.example.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;

public class LogOut implements Command {

    public String execute(HttpServletRequest request) {
        CommandUtility.removeLoggedUser(request.getSession(), null);
        CommandUtility.setUserRole(request, null);
        return "redirect:/index.jsp";
    }
}
