<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Form</title>
</head>
<body>
<h4>Update form</h4>
<form action="updateUser/${employee.employeeId}" method="get">
Enter name: <input type="text" placeholder="enter user name" name="name" value="${employee.name}" required> <br><br>
Enter address: <input type="text" placeholder="enter user address" name="address" value="${employee.address}" required> <br><br>
<input type="submit"> <input type="reset">
</form>
</body>
</html>