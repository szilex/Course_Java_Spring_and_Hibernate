<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: szile
  Date: 02.06.2020
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student form</title>
</head>
<body>

<form:form action="processForm" modelAttribute="student">

    First name: <form:input path="firstName"/>

    <br><br>

    Last name: <form:input path="lastName"/>

    <br><br>

    <form:select path="country">
        <form:options items="${student.countryOptions}"/>
    </form:select>

    <br><br>

    <form:radiobuttons path="languages" items="${student.languagesOptions}"/>
<%--    <form:radiobutton path="language" value="Java"/>Java
    <form:radiobutton path="language" value="C#"/>C#
    <form:radiobutton path="language" value="Python"/>Python
    <form:radiobutton path="language" value="Ruby"/>Ruby--%>

    <br><br>

    Windows<form:checkbox path="operatingSystems" value="Windows"/>
    Linux<form:checkbox path="operatingSystems" value="Linux"/>
    MacOS<form:checkbox path="operatingSystems" value="MacOS"/>

    <br><br>

    <input type="submit" value="Submit"/>

</form:form>

</body>
</html>
