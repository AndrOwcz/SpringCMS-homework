<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script>
        function confirmDelete(id, name) {
            if (confirm("Are you sure to delete category \"" + name + "\"")) {
                window.location.href = "/category/delete/" + id;
            }
        }
    </script>
</head>
<body>
<table>
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="category" items="${categories}">
        <tr>
            <td>${category.name}</td>
            <td>${category.description}</td>
            <td><a href="/category/edit/${category.id}">edit</a></td>
            <td><a href="#" onclick="confirmDelete(${category.id}, '${category.name}')">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>