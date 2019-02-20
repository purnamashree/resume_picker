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
	<script type="text/javascript">
		function checkPassword(str) {
			var re = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;
			return re.test(str);
		}

		function checkForm(form) {
			if (form.username.value == "") {
				alert("Error: Username cannot be blank!");
				form.username.focus();
				return false;
			}
			//re = /^\w+$/;
			var re = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/
			if (!re.test(form.username.value)) {
				alert("Error: Username must be an email address");
				form.username.focus();
				return false;
			}
			if (form.newPassword.value != ""
					&& form.newPassword.value == form.confirmPassword.value) {
				if (!checkPassword(form.newPassword.value)) {
					alert("password should be of Minimum eight characters, at least one letter and one number");
					form.newPassword.focus();
					return false;
				}
			} else {
				alert("Error: Please check that you've entered password and confirmed your password!");
				form.newPassword.focus();
				return false;
			}
			alert("You have successfully changed your password!")
			return true;
		}
	</script>
	<form action="login_page" method="post" onsubmit="return checkForm(this);">
<div class="container">
      <label for="username"><b>Email Id</b></label>
      <input type="text" placeholder="Enter Email Id" name="username" required>
		<br>
      <label for="password"><b>New Password</b></label>
      <input type="password" placeholder="Enter New Password" name="newPassword" required>
        <br>
       <label for="password"><b>Confirm Password</b></label>
      <input type="password" placeholder="Re-enter Password" name="confirmPassword" required>
        <br>
      <button type="submit">Update</button>
      <button type="reset" class="cancelbtn">Cancel</button>
	  <br>
     
    </div>
	</form>
</body>
</html>