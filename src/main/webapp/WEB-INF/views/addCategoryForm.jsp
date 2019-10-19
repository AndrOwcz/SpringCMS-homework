<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="category">
    Name: <form:input type="text" path="name"/>
    <form:errors path="name" cssClass="error"/><br>
    Description: <form:input type="text" path="description"/><br>
    <form:errors path="description" cssClass="error"/> <br>
    <input type="submit" value="Submit">
</form:form>
</body>
</html>
