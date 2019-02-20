<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<form action="admin_page" method="post">


		<div class="topnav">
			<a class="active" href="#home">Home</a>
			
			<a href="uploadResumes.jsp">Upload resumes</a>
			<a href="#news">Create user</a> 
			<a href="#contact">View users</a>
			<a href="#contact">Delete user</a>
			<a href="#about">Logout</a>
		</div>

		<div class="wrap">
			<div class="search">
				<input type="text" class="searchTerm"
					placeholder="Enter keywords(skills, experience etc.)">
				<button type="submit" class="searchButton">
					<i class="fa fa-search"></i>
				</button>
			</div>
		</div>
	</form>
</body>
</html>