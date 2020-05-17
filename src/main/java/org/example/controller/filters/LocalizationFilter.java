package org.example.controller.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;
import java.util.Optional;

public class LocalizationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        String lang = request.getParameter("lang");
        Locale locale;
        if (lang != null){
            if (lang.equals("UKR")) locale = new Locale("uk");
            else locale = new Locale("en");
            session.setAttribute("locale", locale);
        }else {
            locale = (Locale) session.getAttribute("locale");
            if (null == locale) {
                locale = new Locale("uk");
                session.setAttribute("locale", locale);
            }
        }
        Messages messages = new Messages(locale);
        request.setAttribute("messages", messages);
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
