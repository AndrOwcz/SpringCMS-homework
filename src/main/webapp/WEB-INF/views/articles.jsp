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
        function confirmDelete(id, title) {
            if (confirm("Are you sure to delete article \"" + title + "\"")) {
                window.location.href = "/article/delete/" + id;
            }
        }
    </script>
</head>
<body>
<table>
    <tr>
        <th>Title</th>
        <th>Author</th>
        <th>Content</th>
        <th>Created</th>
        <th>Updated</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="article" items="${articles}">
        <tr>
            <td>${article.title}</td>
            <td>${article.author.fullName}</td>
            <td>${article.content}</td>
            <td>${article.created}</td>
            <td>${article.updated}</td>
            <td><a href="/article/edit/${article.id}">edit</a></td>
            <td><a href="#" onclick="confirmDelete(${article.id}, '${article.title}')">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>