<%--
  Created by IntelliJ IDEA.
  User: szile
  Date: 02.06.2020
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer form confirmation</title>
</head>
<body>
The customer is confirmed: ${customer.firstName} ${customer.lastName} <br>
Free passes: ${customer.freePasses} <br>
Postal code: ${customer.postalCode} <br>
Course code: ${customer.courseCode} <br>
</body>
</html>
