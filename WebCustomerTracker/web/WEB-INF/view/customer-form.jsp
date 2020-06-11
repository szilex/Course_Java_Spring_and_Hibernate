<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
    <title>Add customer form</title>

    <link type="text/css"
        rel="styleshee"
        href="${pageContext.request.contextPath}/resources/css/style.css">

    <link type="text/css"
          rel="styleshee"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>

    <div id="wrapper">
        <div id="header">
            <h2>Customer Manager</h2>
        </div>
    </div>

    <div id="container">
        <h3>Enter credentials:</h3>

        <form:form action="saveCustomer" modelAttribute="newCustomer" method="post">

            <form:hidden path="id" />

            <table>
                <tbody>
                    <tr>
                        <td><label>First name:</label></td>
                        <td><form:input path="firstName" /></td>
                    </tr>
                    <tr>
                        <td><label>Last name:</label></td>
                        <td><form:input path="lastName" /></td>
                    </tr>
                    <tr>
                        <td><label>Email name:</label></td>
                        <td><form:input path="email" /></td>
                    </tr>
                    <tr>
                        <td><label></label></td>
                        <td><input type="submit" value="Save" class="save" /></td>
                    </tr>
                </tbody>
            </table>
        </form:form>

        <div style="clear:both"></div>

        <p>
            <a href="${pageContext.request.contextPath}/customer/list">Return to list</a>
        </p>
    </div>

</body>

</html>
