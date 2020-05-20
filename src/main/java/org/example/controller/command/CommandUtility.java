package org.example.controller.command;

import org.example.model.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Locale;

public class CommandUtility {

    static void setUserRole(HttpServletRequest request,
                            User.ROLE role, User user) {

        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setAttribute("role", role);
        request.setAttribute("userName", getCurrentUserName(session));
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
            loggedUsers = new HashSet<>();
        }
        else if(loggedUsers.stream().anyMatch(userName::equals)){
            return true;
        }
        loggedUsers.add(userName);
        request.getSession().getServletContext()
                .setAttribute("loggedUsers", loggedUsers);
        return false;
    }

    public static void removeLoggedUser(HttpSession session){
        HashSet<String> loggedUsers = (HashSet<String>) session.getServletContext()
                .getAttribute("loggedUsers");
        if (loggedUsers != null) {
            String userName = (String) session
                    .getAttribute("userName");
            loggedUsers.remove(userName);
            session.setAttribute("loggedUsers", loggedUsers);
        }
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
            for (int i = 0; i < encodedPassword.length; i++) {
                if ((encodedPassword[i] & 0xff) < 0x10) {
                    sb.append("0");
                }
                sb.append(Long.toString(encodedPassword[i] & 0xff, 16));
            }
           return sb.toString();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

}
