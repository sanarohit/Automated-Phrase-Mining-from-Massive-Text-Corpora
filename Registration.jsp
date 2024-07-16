<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
    font-family: Arial, Helvetica, sans-serif;
    background-color: white;
}

* {
    box-sizing: border-box;
}

/* Add padding to containers */
.container {
    padding: 16px;
    background-color: white;
}


/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 15px;
    margin: 5px 0 22px 0;
    display: inline-block;
    border: none;
    background: #f1f1f1;
}
select{
width: 100%;
padding: 12px;
font-size:25px;
border: 1px solid #ccc;
border-radius: 4px;
box-sizing: border-box;
margin-top: 6px;
margin-bottom: 16px;
resize: vertical;
}

input[type=text]:focus, input[type=password]:focus {
    background-color: #ddd;
    outline: none;
    
}
input[type=radio]{
height:30px;
width:44px;

}

/* Overwrite default styles of hr */
hr {
    border: 1px solid #f1f1f1;
    margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
    background-color: #4CAF50;
    color: white;
    padding: 16px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
    opacity: 0.9;
}

.registerbtn:hover {
    opacity: 1;
}

/* Add a blue text color to links */
a {
    color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
    background-color: #f1f1f1;
    text-align: center;
}

</style>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="HomeMenu.jsp"></jsp:include>
<center>
<form action="RegistrationServlet"style="width:900px;">
<center><h2><font face="Yu Mincho Demibold" style="color: #00BFFF;"><font size="8" >Register Here</font></font></h2></center>
  <div class="container" style="text-align: left">
    <center><label><font color="red" size="4"><% String status=request.getParameter("status"); if(status!=null){out.println(status);} %></font></label> </center>
    
    <hr>


	
    <label for="email" style="color:green"><b>LOGINID</b></label>
    <input type="text" placeholder="Create LoginId" name="uid" required>

    <label for="psw" style="color:green"><b>PASSWORD</b></label>
    <input type="password" placeholder="Create Password" name="pass"  required><!--


      <label for="psw-repeat" style="color:blue"><b>ROLE</b></label>
    <select name="role"   required>
	   <option value="User">User</option>  
	    <option value="Admin">Admin</option>
        </select>
   
     -->
     <label for="psw" style="color:green"><b>ROLE</b></label>
    <input type="text" placeholder="Create Password" name="role"  value="User" required>

     
     
     <label for="email" style="color:green"><b>USERNAME</b></label>
    <input type="text" placeholder="Enter User Name" name="uname" required>
 <label for="psw" style="color:green"><b>GENDER</b></label>
<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Male
							<input type="radio" size="54"  name="g" id="g" value="M" checked="checked" />
							&nbsp; FeMale					
							
		<input type="radio" name="g" id="g" value="F" /><br><br>&nbsp;
		<label for="psw" style="color:green"><b>MAIL</b></label>
      <input type="text" placeholder="Enter MailId" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required>

    <label for="psw-repeat" style="color:green"><b>MOBILE</b></label>
    <input type="text" placeholder="Enter Valid Mobile Number" name="mob" pattern="[7896][0-9]{9}" required>
    

    <label for="psw-repeat" style="color:green"><b>ADDRESS</b></label>
    <input type="text" placeholder="Enter Address" name="uaddress" required>
    
        
    
    <hr>
    

    <button type="submit" class="registerbtn">Register</button>
  </div>
  
  <div class="container signin">
    <p>Already have an account? <a href="Login.jsp">Sign in</a>.</p>
  </div>
</form>
</center>
</body>
</html>
