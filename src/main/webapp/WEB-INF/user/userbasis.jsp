<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>USER</title>

</head>
<body>

<h1>Hello USER!</h1>


        <h2>
            Accounts List <br/>
        </h2>
        <table>
        <tr><th>Id</th><th>Balance</th><th>Validity</th></tr>
        <c:forEach var="i" items="${accounts}">
            <tr><td>${i.id}</td><td><c:out value="${i.balance}"/></td><td>${i.validity}</td>
        </c:forEach>
        </table>
        <br>
        <br>
        <br>

    <a href="${pageContext.request.contextPath}/info">Account info</a> <br>
    <a href="${pageContext.request.contextPath}/transfer">Transfer money</a> <br>
    <a href="${pageContext.request.contextPath}/bill">Pay the bill</a> <br>
    <a href="${pageContext.request.contextPath}/logout">Logout</a>


</body>
</html>