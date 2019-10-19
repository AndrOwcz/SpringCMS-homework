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
            if (confirm("Are you sure to delete draft \"" + title + "\"")) {
                window.location.href = "/draft/delete/" + id;
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
        <th>Draft</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="draft" items="${drafts}">
        <tr>
            <td>${draft.title}</td>
            <td>${draft.author.fullName}</td>
            <td>${draft.content}</td>
            <td>${draft.created}</td>
            <td>${draft.updated}</td>
            <td>${draft.draft}</td>
            <td><a href="/draft/edit/${draft.id}">edit</a></td>
            <td><a href="#" onclick="confirmDelete(${draft.id}, '${draft.title}')">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>