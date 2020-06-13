
<%--
  Created by IntelliJ IDEA.
  User: szile
  Date: 13.06.2020
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Custom login form</title>

    <style>
        .failed {
            color: red;
        }
    </style>
</head>
<body>
    <form action="${pageContext.request.contextPath}/authenticateUser" method="post">

        <c:if test="${param.error != null}">
            <i class="failed">Sorry, but your credentials are incorrect</i>
        </c:if>

        <p>
            User name: <input type="text" name="username" />
        </p>jo
        <p>
            Password: <input type="password" name="password" />
        </p>

        <input type="submit" value="Login"/>
    </form>
</body>
</html>
