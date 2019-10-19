<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="article">

    Title: <form:input type="text" path="title"/>
    <form:errors path="title" cssClass="error"/><br>

    <label>Author:</label>
    <form:select path="author.id" itemValue="id" itemLabel="fullName" items="${authors}"/>
    <br>
    <form:errors path="author.id" cssClass="error"/> <br>

    <label>Categories:</label>
    <form:select path="categories" itemValue="id" itemLabel="name" items="${categories}"/>
    <br>
    <form:errors path="categories" cssClass="error"/> <br>

    Content: <form:input type="text" path="content"/><br>
    <form:errors path="content" cssClass="error"/> <br>

    <form:hidden path="created"/><br>

    <input type="submit" value="Submit">
</form:form>
</body>
</html>
