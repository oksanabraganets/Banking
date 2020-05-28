package org.example.controller.command;

import org.example.model.service.AdminService;

import javax.servlet.http.HttpServletRequest;

public class AdminBasis implements Command {

    public String execute(HttpServletRequest request) {
        return "/WEB-INF/admin/adminbasis.jsp";
    }
}
