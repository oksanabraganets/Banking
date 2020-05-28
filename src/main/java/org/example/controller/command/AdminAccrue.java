package org.example.controller.command;

import org.example.model.service.AdminService;

import javax.servlet.http.HttpServletRequest;

public class AdminAccrue implements Command {
    private AdminService adminService;

    public AdminAccrue(AdminService adminService) {
        this.adminService = adminService;
    }

    public String execute(HttpServletRequest request) {
        adminService.accrueAllInterests();
        return "/WEB-INF/admin/adminbasis.jsp";
    }
}
