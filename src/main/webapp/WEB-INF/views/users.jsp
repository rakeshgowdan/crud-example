<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Info</title>
</head>
<body>
<h4>Employee Information</h4>
<hr>
<table border="1">
        <tr>
            <th>Employee Id</th>
            <th>Name</th>
            <th>Address</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${employeeList}" var="emp">
            <tr>
                <td>${emp.employeeId}</td>
                <td>${emp.name}</td>
                <td>${emp.address}</td>
                <td><a href="fetchUserById/${emp.employeeId}">Update</a> 
                | 
                <a href="deleteUserById/${emp.employeeId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
<hr>
<a href="add.jsp">AddUser</a>
</body>
</html>