<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" href="LoginStyle.css">
</head>
<body>

<div class="imgcontainer">
      <img src="login_image.png">
    </div>


<form action="logged_in" method="post">
<div class="container">
      <label for="username"><b>Email Id</b></label>
      <input type="text" placeholder="Enter Email Id" name="username" required>
		<br>
      <label for="password"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="password" required>
        <br>
      <button type="submit">Login</button>
	  <br>
      <label>
        <input type="checkbox" checked="checked" name="remember"> Remember me
      </label>
    </div>
	
    <div style="background-color:#f1f1f1">
      <button type="reset" class="cancelbtn">Cancel</button>
      <span class="psw"><a href="changePassword.jsp">Forgot password?</a></span>
    </div>
  </form>
 <script>
// Get the modal

</script>
	<!-- <form action="login_page" method="post">
		Email Id:<input type="text" name="username" /><br>
		Password:<input type="text" name="password" /><br>
		<!--FirstName:<input type="text" name="fname" /><br>
		LastName:<input type="text" name="lname" /><br>
		Email Id:<input type="text" name="email" /><br>
		Password:<input type="text" name="pword" /><br>
		Created Date:<input type="date" name="cdate" /><br>
		Modified Date:<input type="date" name="mdate" /><br>
		Created By:<input type="text" name="cby" /><br>
		Role Id:<input type="text" name="roleid" /><br>-->
		<!-- <input type="submit" value="Login" />
		<input type="button" value="cancel" />
	</form>-->
</body>
</html>