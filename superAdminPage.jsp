<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<form action="super_admin_page" method="post">
	<!--  <div class="dropdown">
			<button class="dropbtn">Other options</button>
			<div class="dropdown-content">
				<a href="AddUser.jsp">Create user</a>
				<a href="#">Update details</a>
				<a href="#">Refresh</a>
				<a href="#">Logout</a>
			</div>
	</div>-->
	
	
	
	
	<div class="topnav">
			
			<a href="AddUser.jsp">Create user</a>
			<a href="#">Update details</a>
			<a href="#">Refresh</a>
			<a href="#">Logout</a>
		</div>
	
	
	
	
	
	
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
					<td><a href="ResumePicker/edit?user_id=<c:out value='${user.userId}' />">Edit</a>
                    <td><a href="/ResumePicker/delete_user?user_id=<c:out value='${user.userId}' />">Delete</a></td>
				</tr>
			</c:forEach>
			
		</table>
	</div>
	</form>
</body>
</html>