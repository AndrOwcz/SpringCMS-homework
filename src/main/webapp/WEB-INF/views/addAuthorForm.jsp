<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="author">
    First Name: <form:input type="text" path="firstName"/>
    <form:errors path="firstName" cssClass="error"/><br>
    Last Name: <form:input type="text" path="lastName"/><br>
    <form:errors path="lastName" cssClass="error"/> <br>
    <input type="submit" value="Submit">
</form:form>
</body>
</html>
