<!DOCTYPE html>
<html>
<head>
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a, .dropbtn {
  display: inline-block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
  background-color: red;
}

li.dropdown {
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
  font-size: 20px;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
  display: block;
}
</style>
</head>
<body>

<ul>
  		<li><a class="inactive" href="AdminHome.jsp"><font size="5">Home</font></a></li>
  
  		<li class="dropdown">
    			<a href="javascript:void(0)" class="dropbtn"><font size="5">View Users</font></a>
    				<div class="dropdown-content">
      						<a href="Viewuserrequestservlet">View Users</a>   
      						<a href="Viewadminprofileservlet">View Profile</a>   					      					
    				</div>
  		</li>
  
  		<li class="dropdown">
   				 <a href="javascript:void(0)" class="dropbtn"><font size="5">Candidate Details</font></a>
         			<div class="dropdown-content">
      						<a href="Addcandidate.jsp">Add Candidate</a>
      						<a href="Viewcandidatedetailsservlet">View all Candidate Details</a>      					      					
      						<a href="Viewaccesspoints.jsp">View candidate Access Points</a>
         			</div>
  		</li>
  
  
  		<li><a href="Searchtransactionservlet"><font size="5">View search Transactions </font></a></li>
  		<li><a href="Autophraseminingservlet"><font size="5">View Auto Phrase Meaning </font></a></li>
  		
  		<li class="dropdown">
    		<a href="javascript:void(0)" class="dropbtn"><font size="5">Pool Search</font></a>
   				 <div class="dropdown-content">
      					<a href="Positivepool.jsp">Positive Pool search</a>
      					<a href="Negativepool.jsp">Negative Pool search</a>      					      					
    			 </div>
  		</li>
  		<li><a href="Adminchangepassword.jsp"><font size="5">Security</font	></a></li>
  		<li><a href="Logout.jsp"><font size="5">Logout</font></a></li>
  		 
  
</ul>
</body>
</html>
