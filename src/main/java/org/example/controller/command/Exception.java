package org.example.controller.command;

import javax.servlet.http.HttpServletRequest;

public class Exception implements Command {

    public String execute(HttpServletRequest request) {
        throw new RuntimeException("Generated exception");
    }
}
