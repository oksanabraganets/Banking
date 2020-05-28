<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, java.text.*" %>
<html>
<head>
    <title>User</title>

</head>
<body>

<h1>${messages.welcome} <c:out value="${userName}"/></h1>

        <form method="get" action="${pageContext.request.contextPath}/userbasis">

            <input class="button" type="submit" name="lang" value="UKR">
            <input class="button" type="submit" name="lang" value="ENG">

        </form>

        <br/>
        <h2>
            ${messages.accounts} <br/>
        </h2>

        <table>
        <tr><th>${messages.id}</th><th>${messages.balance}</th><th>${messages.validity}</th></tr>
        <c:forEach var="i" items="${user.getAccounts()}">
            <tr><td>${i.id}</td><td><c:out value="${i.balance}"/></td><td>${i.validity}</td>
        </c:forEach>
        </table>
        <br>
        <br>
        <br>

    <a href="${pageContext.request.contextPath}/info">${messages.info}</a> <br>
    <a href="${pageContext.request.contextPath}/transfer">${messages.transfer}</a> <br>
    <a href="${pageContext.request.contextPath}/bill">${messages.bill}</a> <br>
    <a href="${pageContext.request.contextPath}/logout">${messages.logout}</a>


</body>
</html>