<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%@page import="com.automated.dto.Profilebean"%>
<%@page import="com.automated.dao.Searchforcandidatedao"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

   
    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">


    <!-- Custom styles for this template -->
    <link href="assets/css/main.css" rel="stylesheet">

    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="assets/js/hover.zoom.js"></script>
    <script src="assets/js/hover.zoom.conf.js"></script>





<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/highcharts.js" type="text/javascript"></script>

<script type="text/javascript">
		
		
			Highcharts.visualize = function(table, options) {
				// the categories
				options.xAxis.categories = [];
				$('tbody th', table).each( function(i) {
					options.xAxis.categories.push(this.innerHTML);
				});
				
				
				options.series = [];
				$('tr', table).each( function(i) {
					var tr = this;
					$('th, td', tr).each( function(j) {
						if (j > 0) { // skip first column
							if (i == 0) { // get the name and init the series
								options.series[j - 1] = { 
									name: this.innerHTML,
									data: []
								};
							} else { // add values
								options.series[j - 1].data.push(parseFloat(this.innerHTML));
							}
						}
					});
				});
				
				var chart = new Highcharts.Chart(options);
			}
				
			
			$(document).ready(function() {			
				var table = document.getElementById('datatable'),
				options = {
					   chart: {
					      renderTo: 'container',
					      defaultSeriesType: 'column'
					   },
					   title: {
					      text: 'RESULT in Counts'
					   },
					   xAxis: {
					   },
					   yAxis: {
					      title: {
					         text: ''
					      }
					   },
					   tooltip: {
					      formatter: function() {
					         return '<b>'+ this.series.name +'</b><br/>'+
					            this.y +' '+ this.x.toLowerCase();
					      }
					   }
					};
				
			      					
				Highcharts.visualize(table, options);
				$('#datatable').hide();
			});
				
		</script>
		
</head>
  
   <body background="./images/rj3.png">
  
  
  <%
   
					Searchforcandidatedao vdd=new Searchforcandidatedao();
					List<Profilebean> list=vdd.positivepool();
					
  
    
   %>

<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="AdminMenu.jsp"></jsp:include>
<center>
<div id="container" style="width: 50%; height: 400px">

</div>
<table id="datatable" border="1" width="134" cellspacing="0" cellpadding="0" height="110">
		
			<thead>
				<tr>
					<th></th>
					
					<%
					Iterator iterator=list.iterator();
					while(iterator.hasNext())
					{
					Profilebean prcc=(Profilebean)iterator.next();
					
					 %>
					
					<th><font color=green><%=prcc.getCandidatename() %></font></th>
				
					<%
					}
					 %>
				</tr>
			</thead>
			<tbody>
			
		
			
				<tr>
				<th></th>
					<%
					Iterator iterator1=list.iterator();
					while(iterator1.hasNext())
					{
					Profilebean prcc=(Profilebean)iterator1.next();
					int val=(int)prcc.getPpoolcount();
					
					
					 %>
					<td><%=val%></td>
					
					<%
					}
					 %>
					
				</tr>
				
			</tbody>
			
			
		</table>
		
		
</center>
  </body>
</html>
