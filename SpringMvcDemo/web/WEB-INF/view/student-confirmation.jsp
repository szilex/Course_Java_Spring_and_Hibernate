<%--
  Created by IntelliJ IDEA.
  User: szile
  Date: 02.06.2020
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Student form confirmation</title>
</head>
<body>

The student is confirmed: ${student.firstName} ${student.lastName} <br>
Origin country: ${student.country} <br>
Favourite language: ${student.languages} <br>
Operating systems:<br>

<ul>
    <c:forEach var="temp" items="${student.operatingSystems}">
        <li>${temp}</li>
    </c:forEach>

</ul>

</body>
</html>
