<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!--<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="delete_user" method="post">
		enter user_id:<input type="text" name="userId" value />
		<input type="submit" value="delete"/>
	</form>
</body>
</html>-->


<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<form action="delete_user" method="post">
	
	<div align="center">
		<table><!-- border="1" cellpadding="5">  -->
			<caption><h2>List of users</h2></caption>
			
			<tr>
				<th>User Id</th>
				<th>Firstname</th>
				<th>Lastname</th>
				<th>Email Id</th>
				<th>Created Date</th>
				<th>Modified Date</th>
				<th>Created By</th>
				<th>Modified By</th>
				<th>Role Id</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			
			<c:forEach var="user" items="${listUser}">
				<tr>
					<td><c:out value="${user.userId}" /></td>
					<td><c:out value="${user.firstName}" /></td>
					<td><c:out value="${user.lastName}" /></td>
					<td><c:out value="${user.emailId}" /></td>
					<td><c:out value="${user.createdDate}" /></td>
					<td><c:out value="${user.modifiedDate}" /></td>
					<td><c:out value="${user.createdBy}" /></td>
					<td><c:out value="${user.modifiedBy}" /></td>
					<td><c:out value="${user.roleId}" /></td>
				</tr>
			</c:forEach>
			
		</table>
	</div>
	</form>
</body>
</html>