<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="upload" method="post">
		<div>
			<input type="file" name="fileupload" value="fileupload" id="fileupload" multiple>
			<input type="submit" value="upload"><br>
			<input type="button" value="retrieve">
		</div>
	</form>
</body>
</html>