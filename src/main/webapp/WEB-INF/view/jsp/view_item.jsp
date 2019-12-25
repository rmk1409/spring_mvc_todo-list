<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.veselov.alex.util.Mappings" %>
<html>
<head>
    <title>View Item</title>
</head>
<body>
<div align="center">
    <table>
        <tr>
            <td><label>ID</label></td>
            <td>${todoItem.id}</td>
        </tr>
        <tr>
            <td><label>Title</label></td>
            <td>${todoItem.title}</td>
        </tr>
        <tr>
            <td><label>Deadline</label></td>
            <td>${todoItem.deadline}</td>
        </tr>
        <tr>
            <td><label>Details</label></td>
            <td>${todoItem.details}</td>
        </tr>
    </table>
    <c:url var="tableUrl" value="${Mappings.ITEMS}"/>
    <a href="${tableUrl}">Show Table</a>
</div>
</body>
</html>
