<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, java.text.*" %>
<html>
<head>
    <title>ADMIN THE BASIS</title>
</head>
<body>

<h2><c:out value="${messages.adminTitle}"/></h2>

<form method="get" action="${pageContext.request.contextPath}/adminbasis">

            <input class="button" type="submit" name="lang" value="UKR">
            <input class="button" type="submit" name="lang" value="ENG">

</form>

<h2> <c:out value="${userName}"/> </h2>
    <br/>
    <form method="get" action="${pageContext.request.contextPath}/accrue">
        <input class="button" type="submit" value=<c:out value="${messages.adminAccrue}"/> >
    </form>
    <br/>
<a href="${pageContext.request.contextPath}/logout"><c:out value="${messages.logout}"/></a>
</body>
</html>