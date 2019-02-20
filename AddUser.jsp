<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="LoginStyle.css">
<script> 
function formValidate()                                    
{ 
    var firstname = document.forms["addUserForm"]["firstname"];               
    var lastname = document.forms["addUserForm"]["lastname"];    
    var email = document.forms["addUserForm"]["email"];  
    var password =  document.forms["addUserForm"]["password"];  
    var created_by = document.forms["addUserForm"]["created_by"];  
    var role = document.forms["addUserForm"]["role"]; 
    
    if (role.value == ""){ 
        window.alert("Please select a role"); 
        role.focus(); 
        return flase; 
    } 
    if (firstname.value == "")                                  
    { 
        window.alert("Please enter your name."); 
        firstname.focus(); 
        return false; 
    } 
   
    if (lastname.value == "")                               
    { 
        window.alert("Please enter your address."); 
        lastname.focus(); 
        return false; 
    } 
       
    if (email.value == "")                                   
    { 
        window.alert("Please enter a valid e-mail address."); 
        email.focus(); 
        return false; 
    } 
   
    if (email.value.indexOf("@", 0) < 0)                 
    { 
        window.alert("Please enter a valid e-mail address."); 
        email.focus(); 
        return false; 
    } 
   
    if (email.value.indexOf(".", 0) < 0)                 
    { 
        window.alert("Please enter a valid e-mail address."); 
        email.focus(); 
        return false; 
    } 
   
    
   
    if (password.value == "")                        
    { 
        window.alert("Please enter your password"); 
        password.focus(); 
        return flase; 
    } 
    if (created_by.value == "")                        
    { 
        window.alert("Please enter created_by"); 
        created_by.focus(); 
        return flase; 
    } 
    
   
   alert("A new usr has been added!")
    return true; 
}</script> 
  
</head>


<body>
<div class="container">
	<form name="addUserForm" action="load" method="post" onsubmit="return formValidate()">
		Role:<select name="role">
				<option>Select</option>
				<option value="Admin">Admin</option>
				<option value="HR">HR</option>
			</select> <br>
		FirstName:<input type="text" name="firstname" /><br>
		LastName:<input type="text" name="lastname" /><br>
		Email Id:<input type="text" name="email" /><br>
		Password:<input type="text" name="password" /><br>
		<!--Created Date:<input type="date" name="created_date" /><br>
		Modified Date:<input type="date" name="modified_date" /><br>-->
		Created By:<input type="text" name="created_by" /><br>
		
		<button type="submit"/>Submit</button>
		<div><input type="reset" value="cancel"  class="cancelbtn" />
			<span class="psw"><a href="superAdminPage.jsp">go to home page</a></span>
		</div>
	</form>
</div>
</body>
</html>