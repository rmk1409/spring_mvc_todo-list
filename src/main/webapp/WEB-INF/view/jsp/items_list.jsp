<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Todo Items</title>
</head>
<body>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Todo Items</h2></caption>
        <tr>
            <th>Title</th>
            <th>Deadline</th>
        </tr>
        <c:forEach var="item" items="${todoData.items}">
            <tr>
                <td>${item.title}</td>
                <td>${item.deadLine}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
