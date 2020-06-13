<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>
<html >

<head>
    <title>Home Page</title>
</head>

<body>
    <h2> Welcome to company Home Page </h2>
    <hr>

    <p>This is the page of a logged user</p>
    <hr>

    <p>
        User: <security:authentication property="principal.username" />
        <br>
        Role(s): <security:authentication property="principal.authorities" />
    </p>
    <hr>

        <security:authorize access="hasRole('MANAGER')">
            <p>
                <a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
                (Only for Managers)
            </p>
            <hr>
        </security:authorize>




        <security:authorize access="hasRole('ADMIN')">
            <p>
                <a href="${pageContext.request.contextPath}/systems">Admins meeting</a>
                (Only for Admins)
            </p>
            <hr>
        </security:authorize>



    <form:form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="submit" value="Logout" />
    </form:form>
</body>

</html>

