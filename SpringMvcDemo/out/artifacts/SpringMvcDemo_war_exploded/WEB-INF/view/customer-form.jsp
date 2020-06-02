<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: szile
  Date: 02.06.2020
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer form with validation</title>

    <style>
        .error {color:red}
    </style>
</head>
<body>

Fill out the form.<br>
Asterisk (*) means the field is required<br><br>

<form:form action="processForm" modelAttribute="customer">

    First name: <form:input path="firstName"/>

    <br><br>

    Last name(*): <form:input path="lastName"/>
    <form:errors path="lastName" cssClass="error"/>

    <br><br>

    Free passes: <form:input path="freePasses"/>
    <form:errors path="freePasses" cssClass="error"/>

    <br><br>

    Postal code: <form:input path="postalCode"/>
    <form:errors path="postalCode" cssClass="error"/>

    <br><br>

    Course code: <form:input path="courseCode"/>
    <form:errors path="courseCode" cssClass="error"/>

    <br><br>

    <%--<form:select path="country">
        <form:options items="${student.countryOptions}"/>
    </form:select>

    <br><br>

    <form:radiobuttons path="languages" items="${student.languagesOptions}"/>
    &lt;%&ndash;    <form:radiobutton path="language" value="Java"/>Java
        <form:radiobutton path="language" value="C#"/>C#
        <form:radiobutton path="language" value="Python"/>Python
        <form:radiobutton path="language" value="Ruby"/>Ruby&ndash;%&gt;

    <br><br>

    Windows<form:checkbox path="operatingSystems" value="Windows"/>
    Linux<form:checkbox path="operatingSystems" value="Linux"/>
    MacOS<form:checkbox path="operatingSystems" value="MacOS"/>

    <br><br>--%>

    <input type="submit" value="Submit"/>

</form:form>
</body>
</html>
