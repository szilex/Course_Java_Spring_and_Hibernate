<%--
  Created by IntelliJ IDEA.
  User: szile
  Date: 14.06.2020
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index page</title>
</head>
<body>
    <h2>Spring REST demo application</h2>
    <hr>
    <a href="${pageContext.request.contextPath}/test/hello">Go to hello world page</a>
    <hr>
    <a href="${pageContext.request.contextPath}/api/students">Get student list</a>
</body>
</html>
