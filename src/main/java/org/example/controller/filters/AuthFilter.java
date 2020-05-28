package org.example.controller.filters;

import org.example.model.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AuthFilter implements Filter {


    Map<String, User.ROLE> uriRoleMap = Stream.of(new Object[][] {
            { "/api/", User.ROLE.ROLE_UNKNOWN },
            { "/api/login", User.ROLE.ROLE_UNKNOWN },
            { "/api/exception", User.ROLE.ROLE_UNKNOWN },
            { "/api/registration", User.ROLE.ROLE_UNKNOWN },
            { "/api/index.jsp", User.ROLE.ROLE_UNKNOWN },
            { "/api/registration.jsp", User.ROLE.ROLE_UNKNOWN },
            { "/api/login.jsp", User.ROLE.ROLE_UNKNOWN },
            { "/api/userbasis", User.ROLE.ROLE_USER },
            { "/api/adminbasis", User.ROLE.ROLE_ADMIN },
            { "/api/accrue", User.ROLE.ROLE_ADMIN },
            { "/api/transfer", User.ROLE.ROLE_USER },
            { "/api/admin/adminbasis.jsp", User.ROLE.ROLE_ADMIN },
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (User.ROLE) data[1]));

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        ServletContext context = request.getServletContext();
        System.out.println(session);
        System.out.println(session.getAttribute("role"));
        System.out.println(context.getAttribute("loggedUsers"));

        String requestURI = req.getRequestURI();
        User.ROLE role = (User.ROLE) session.getAttribute("role");
        if (role == null) role = User.ROLE.ROLE_UNKNOWN;

        System.out.println("URI: " + requestURI);
        System.out.println("uriRoleMap: " + uriRoleMap.get(requestURI));
        if (requestURI.equals("/api/logout")){
            filterChain.doFilter(request,response);
            return;
        }
        if (role == uriRoleMap.get(requestURI)){
            filterChain.doFilter(request,response);
        }else{
            if (role == User.ROLE.ROLE_UNKNOWN) res.sendRedirect("/api/WEB-INF/index.jsp");
            if (role == User.ROLE.ROLE_USER) res.sendRedirect("/api/userbasis");
            if (role == User.ROLE.ROLE_ADMIN) res.sendRedirect("/api/adminbasis");
        }
    }

    @Override
    public void destroy() {

    }

}
