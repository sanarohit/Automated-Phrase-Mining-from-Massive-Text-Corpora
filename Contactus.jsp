<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Contactus.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <center>

			<jsp:include page="Header.jsp"></jsp:include>
			<jsp:include page="HomeMenu.jsp"></jsp:include></div>
			
			   
			<br/>
			<br/>
			<br/>
			<br/>
			<center>
			<h2><font color="red"><b>Contact Details</b></font></h2>
    <table border="0" width="" height="162" align>
	
	
				<tr>
					<td align='left'> 
					<font color="#FF5733"> NAME </font>
					</td>
					<td align='left'>&nbsp;&nbsp;&nbsp;&nbsp; 
							<font color="#7B68EE">Naresh i Technologies</font>
					<br></td></tr>
				
					<tr>
					<td align='left'>
					<font color="#FF5733"> MOBILE </font>
					</td>
					<td align="left">&nbsp;&nbsp;&nbsp;&nbsp; 
							<font color="#7B68EE">9000994005</font>
					<br></td></tr>
					<tr>
					<td align='left'> 
					<font color="#FF5733">	MAIL ID</font>
					</td>
						<td align="left">&nbsp;&nbsp;&nbsp;&nbsp; 
						<font color="#7B68EE">projects@nareshit.com</font>
					<br></td>
					</tr>
					<tr>
					<td align='left'>
					<font color="#FF5733">	PROJECT</font> 
					</td>
						<td align="left">&nbsp;&nbsp;&nbsp;&nbsp; <font color="#7B68EE">Automated Phrase Mining </br> &nbsp; &nbsp; &nbsp;from Massive Text Corpora</font>
					<br></td>
					</tr>
				</table>
				</center>
			
				</center>
				<div style="margin-top: -3px;">
				<jsp:include page="Footer.jsp"></jsp:include>
		</div>
  </body>
</html>
