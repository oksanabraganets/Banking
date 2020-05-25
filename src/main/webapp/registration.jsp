<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration form</title>

</head>
<body>
        <h2>
            This is registration form! <br/>
        </h2>
        <br/>
                <form method="get" action="${pageContext.request.contextPath}/registration">
                    <div class="form-group">
                        <label>First name</label>
                        <input type="text" name="first_name"><br/>
                    </div>
                    <div class="form-group">
                        <label>Last name</label>
                        <input type="text" name="last_name"><br/>
                    </div>
                    <div class="form-group">
                        <label>First name UKR</label>
                        <input type="text" name="first_name_uk"><br/>
                    </div>
                    <div class="form-group">
                        <label>Last name UKR</label>
                        <input type="text" name="last_name_uk"><br/>
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" name="email"><br/>
                    </div>
                    <div class="form-group">
                        <label>Password</label>
                        <input type="password" name="pass"><br/><br/>
                    </div>
                    <input class="button" type="submit" value="Sign up">
                </form>
                <br/>
        <p> <%= session.getAttribute("message") %> </p>
        <a href="${pageContext.request.contextPath}/index.jsp">Index</a>
</body>
</html>