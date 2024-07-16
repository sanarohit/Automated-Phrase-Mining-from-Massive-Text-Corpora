

<%@page import="java.util.ArrayList"%>

<%@page import="com.automated.dao.Addcandidatedao"%>
<%@page import="com.automated.dto.Profilebean"%><!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=password]{
    width: 780px;
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
    width: 820px;
}
file {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
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
.container {
    padding: 16px;
    width: 800px;
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
<center>
<form action="Searchforcandidateservlet" style="width:900px;">
  
<center><label><font color="red" size="4"><% String status=request.getParameter("status"); if(status!=null){out.println(status);} %></font></label> </center>     
           
  <div class="container" style="text-align: left">

<center><h2><font face="Yu Mincho Demibold" style="color: #FF5733;"><font size="6" >Search for Candidates</font></font></h2></center>


     <%
				String u = (String) session.getAttribute("uname");
				if (u == null) {
					String target = "Login.jsp?status=Please Enter UserName and Password";
					RequestDispatcher rd = request.getRequestDispatcher(target);
					rd.forward(request, response);
				}
			%>
				 
    
   <label style="color: rgb(0, 0, 136); ">Candidate Name </label>&nbsp;&nbsp;&nbsp;&nbsp;
    <select name="candidatename"   required>
	   <option value="">-------Select------</option>  
	   <%	 Addcandidatedao dao1=new Addcandidatedao(); 
		ArrayList al=dao1.getcandidatenames();
      System.out.println("size of al--->" + al.size());

						for (int i = 0;i <al.size(); i++)
						 {
					
							Profilebean count = (Profilebean) al.get(i);
							
	 %> 
     <option value="<%=count.getCandidatename()%>"><%=count.getCandidatename()%></option>
      
      
   <%
        }
      %> 
        </select>
      
<br/>

    
    <button type="submit">Search</button>
    </div>
    </form>
  
</center>
</body>
</html>
