<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>TRANSFER</title>

</head>
<body>

<h1>Hello on transfer page</h1>
        <br>
        <form method="get" action="${pageContext.request.contextPath}/transfer">
            <select name="source">
                <c:forEach items="${sessionScope.user.accounts}" var="account">
                <option value="${account.id}">Id:${account.id}  Balance:<c:out value="${account.balance}"/></option>
                </c:forEach>
            </select>
            <br><br>
            <input type="text" name="dest">
            <br><br>
            <input type="text" name="amount">
            <br><br>
            <input class="button" type="submit" value="Transfer">
        </form>
        <br>

        <br>

    <a href="${pageContext.request.contextPath}/userbasis">To the main page</a> <br>
    <a href="${pageContext.request.contextPath}/logout">Logout</a>


</body>
</html>