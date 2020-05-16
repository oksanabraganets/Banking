<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <body>
        <h2>
            Hello World!
        </h2>

    <br/>
        <a href="${pageContext.request.contextPath}/login"><c:out value="${messages.getLogin()}"/></a>
    <br/>
        <a href="${pageContext.request.contextPath}/registration"><c:out value="${messages.getRegistration()}"/></a>
    <br>
        <a href="${pageContext.request.contextPath}/exception">Exception</a>

    </body>
</html>