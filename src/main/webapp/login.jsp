<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
</head>
<body>

        <h1><c:out value="${messages.getLoggingIn()}"/></h1><br/>

        <form method="get" action="${pageContext.request.contextPath}/login">

            <input class="button" type="submit" name="lang" value="UKR">
            <input class="button" type="submit" name="lang" value="ENG">

        </form>
        <br/>
        <form method="get" action="${pageContext.request.contextPath}/login">

            <input type="text" name="name"><br/>
            <input type="password" name="pass"><br/><br/>
            <input class="button" type="submit" value="<c:out value="${messages.getLogin()}"/>">

        </form>
        <br/>
        <a href="${pageContext.request.contextPath}/logout"><c:out value="${messages.getToHome()}"/></a>

</body>
</html>