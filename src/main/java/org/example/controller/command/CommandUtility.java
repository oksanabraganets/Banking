package org.example.controller.command;

import org.example.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Locale;
import java.util.Optional;

public class CommandUtility {

    static void setUserRole(HttpServletRequest request, User user) {

        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setAttribute("role", user.getRole());
        request.setAttribute("userName", getCurrentUserName(session));
        HashSet<String> loggedUsers = (HashSet<String>) session.getServletContext()
                .getAttribute("loggedUsers");
        if(loggedUsers == null){
            loggedUsers = new HashSet<>();
        }
        loggedUsers.add(user.getEmail());
        session.getServletContext().setAttribute("loggedUsers", loggedUsers);
    }

    public static String getCurrentUserName(HttpSession session){
        Locale locale = (Locale) session.getAttribute("locale");
        User user = (User) session.getAttribute("user");
        if (user == null) return null;
        if (locale.toString().equals("uk")){
            return user.getFirstNameUkr() + " " + user.getLastNameUkr();
        }
        return user.getFirstName() + " " + user.getLastName();
    }

    static boolean checkUserIsLogged(HttpServletRequest request, String userName){
        HashSet<String> loggedUsers = (HashSet<String>) request.getSession().getServletContext()
                .getAttribute("loggedUsers");
        if(loggedUsers == null){
            return false;
        }
        else if(loggedUsers.stream().anyMatch(userName::equals)){
            return true;
        }
        return false;
    }

    public static void removeLoggedUser(HttpSession session, String name){
        HashSet<String> loggedUsers = (HashSet<String>) session.getServletContext()
                .getAttribute("loggedUsers");
        if (loggedUsers == null) return;
        User user = (User) session.getAttribute("user");
        Optional<String> login = Optional.ofNullable(name);
        loggedUsers.remove(login.orElse(user.getEmail()));
        session.getServletContext().setAttribute("loggedUsers", loggedUsers);
        session.setAttribute("user", user);
        session.setAttribute("role", User.ROLE.ROLE_UNKNOWN);
        }

    public static String hashPassword(String password){

        String algorithm = "SHA";
        byte[] plainText = password.getBytes();

        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);

            md.reset();
            md.update(plainText);
            byte[] encodedPassword = md.digest();

            StringBuilder sb = new StringBuilder();
            for (byte b : encodedPassword) {
                if ((b & 0xff) < 0x10) {
                    sb.append("0");
                }
                sb.append(Long.toString(b & 0xff, 16));
            }
           return sb.toString();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

}
