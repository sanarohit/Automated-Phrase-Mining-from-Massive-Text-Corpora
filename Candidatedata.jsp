<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.automated.dto.Profilebean"%>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ViewUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<style type="text/css">

#myInput {
  background-image: url('/css/searchicon.png');
  background-position: 10px 10px;
  background-repeat: no-repeat;
  width: 100%;
  font-size: 16px;
  padding: 12px 20px 12px 40px;
  border: 1px solid #ddd;
  margin-bottom: 12px;
}

#myTable {
  border-collapse: collapse;
  width: 1000;
  border: 1px solid #ddd;
  font-size: 15px;
}

#myTable th, #myTable td {
  text-align: center;
  padding: 15px;
}

#myTable tr {
  border-bottom: 1px solid #ddd;
}

#myTable tr.header, #myTable tr:hover {
  background-color: #f1f1f1;
}
</style>
  </head>
  
  <body>
  <%
				String u = (String) session.getAttribute("uname");
				if (u == null) {
					String target = "Login.jsp?status=Please Enter UserName and Password";
					RequestDispatcher rd = request.getRequestDispatcher(target);
					rd.forward(request, response);
				}
			%>
   <center>

			<jsp:include page="Header.jsp"></jsp:include>
			<jsp:include page="UserMenu.jsp"></jsp:include>
			<div class="signup" style="margin-top: -1px; width: 100%;">
			
			<center>
  <%
    ArrayList<Profilebean> al=new ArrayList<Profilebean>();
    al=(ArrayList)session.getAttribute("list");
   
    int size=al.size();
     %>
   <center><br/><h2><font face="Yu Mincho Demibold" style="color: #00BFFF;"><font size="8" >View Candidate Details<br></font></font></h2></center>
    <center><label><font color="red" size="4"><% String status=request.getParameter("status");if(status!=null){out.println(status);} %></font></label> </center>
    
<table id="myTable" style="width:100%">
<tr class="header" style="background-color: #F0F8FF;">
<th style="width:20%; color:#8B0000">CID</th>
 <th style="width:20%; color:#8B0000">CANDIDATE_NAME</th>
 <th style="width:20%; color:#8B0000">TOPIC_NAMES</th>
 <th style="width:20%; color:#8B0000">DESCRIPTION</th>
 <th style="width:20%; color:#8B0000">UPLOADED_DATE</th>
 <th style="width:20%; color:#8B0000">ACCESSPOINTS</th>
   
  </tr>
 
  <%for(Profilebean pb:al){ %>
  
<tr  class="header">

<td>
  <font color="green"><%=pb.getCid()%></font>
</td>
 <td>
  <font color="green"><%=pb.getCandidatename()%></font>
</td>
  
   <td>
  <font color="green"><%=pb.getTopicname()%></font>
</td>
  
<td>
<font color="green"><%=pb.getDesc()%></font>
 </td>
 
  
  <td>
<font color="green"><%=pb.getDate()%></font>
 </td>
 
 <td>
<font color="green"><%=pb.getAccesspoint()%></font>
 </td>
 </tr>
 
 
  <%  } %>
  
</table>
 </center>
 </div>
 
 </center>

   <div style="margin-top: -3px;">
				<jsp:include page="Footer.jsp"></jsp:include>
		</div> 
  
  </body>
</html>
