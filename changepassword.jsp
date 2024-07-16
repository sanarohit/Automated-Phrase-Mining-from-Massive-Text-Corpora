<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=password] {
    width: 830px;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 870px;
}

button:hover {
    opacity: 0.8;
}

.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}

.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
}

img.avatar {
    width: 40%;
    border-radius: 50%;
}

.container {
    padding: 16px;
}

span.psw {
    float: right;
    padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
</style>
</head>
<body>

<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="UserMenu.jsp"></jsp:include>
<%
				String u = (String) session.getAttribute("uname");
				if (u == null) {
					String target = "Login.jsp?status=Please Enter UserName and Password";
					RequestDispatcher rd = request.getRequestDispatcher(target);
					rd.forward(request, response);
				}
			%> 

<center>
<center><h2><font face="Yu Mincho Demibold" style="color: #00BFFF;"><font size="8" >Change password</font></font></h2></center>

<form action="ChangepasswordServlet" style="width:900px;">
  <div class="imgcontainer">
    <br>
  </div>
<center><label><font color="red" size="4"><% String status=request.getParameter("status"); if(status!=null){out.println(status);} %></font></label> </center>     
           
  <div class="container" style="text-align: left">
    <label for="uname" style="color:blue"><b>LOGIN ID</b></label>
    <input type="text" placeholder="Enter Username" name="userid" value="<%=session.getAttribute("uname")%>"  readonly="readonly">

    <label for="psw" style="color:blue"><b>OLD PASSWORD</b></label>
    <input type="password" placeholder="Enter Old Password" name="pass" required>
        
        <label for="psw" style="color:blue"><b>NEW PASSWORD</b></label>
    <input type="password" placeholder="Enter New Password" name="newpass"  required>
        
    <button type="submit">CHANGE PASSWORD</button>
    </div>
    </form>
</center>
</body>
</html>
