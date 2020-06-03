package org.example.controller.listener;

import org.example.controller.command.CommandUtility;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent httpSessionEvent) {}

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        CommandUtility.removeLoggedUser(httpSessionEvent.getSession(), null);
    }
}
