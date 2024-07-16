

<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=password] {
    width: 100%;
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
    width: 100%;
}
select{
width: 820px;
padding: 12px;
font-size:25px;
border: 1px solid #ccc;
border-radius: 4px;
box-sizing: border-box;
margin-top: 6px;
margin-bottom: 16px;
resize: vertical;
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
<jsp:include page="AdminMenu.jsp"></jsp:include>
<center>
<center><h2><font face="Yu Mincho Demibold" style="color: #00BFFF;"><font size="8" >Add Candidate Details</font></font></h2></center>

<form action="Addcandidateservlet" style="width:900px;">
 
<center><label><font color="red" size="4"><% String status=request.getParameter("status"); if(status!=null){out.println(status);} %></font></label> </center>     
           
  <div class="container" style="text-align: center;">
	
  
	 <label for="uname" style="color:blue"><b>Candidate Name</b></label>
    <input type="text" placeholder="Enter Candidate Name" name="candname" required>
    
    <label for="uname" style="color:blue"><b>Topic Name</b></label>
    <input type="text" placeholder="Enter Topic Name" name="tname" required>
    

    <label for="psw" style="color:blue"><b>Description</b></label>
    <input type="text" placeholder="Enter Description" name="desc" required>
       
        
            <button type="submit">Add Details</button>
    </div>
    </form>
</center>
</body>
</html>
