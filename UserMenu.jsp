<!--<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="css/newtamplate.css" type="text/css"></link>

<style type="text/css">
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
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
  display: block;
}



</style>
</head>
<body>
	<ul>
  		<li><a class="inactive" href="UserHome.jsp"><font size="5">Home</font></a></li>
  		
  		<li class="dropdown">
   			 <a href="javascript:void(0)" class="dropbtn">View Bank A/C</a>
    			<div class="dropdown-content">
      					<a href="#">My A/C Details</a>
      					<a href="#">Create Bank A/C</a>
      					<a href="#">Add Money</a>
   				 </div>
  		</li>
  		
  		<li><a href="Viewoldpasswordservlet"><font size="5">Request Credit Card</font></a></li> 		
 		<li class="dropdown">
   			 <a href="javascript:void(0)" class="dropbtn">Dropdown</a>
    			<div class="dropdown-content">
      					<a href="#">View Credit Card Details</a>
      					<a href="#">View Card T/F</a>
      					<a href="#">View All T/P companies</a>
   				 </div>
  		</li>
 		<li><a href="Dosattackservlet"><font size="5">Search Company </font></a></li>
 		<li><a href="Bruteforceattackservlet"><font size="5">View All Booking History</font></a></li> 		
  		<li><a href="Viewuserprofileservlet"><font size="5">View Profile</font></a></li>
  		<li><a href="changepassword.jsp"><font size="5">Security</font	></a></li>
  		<li><a href="Logout.jsp"><font size="5">Logout</font></a></li>
  		 
	</ul>

</body>
</html>

-->

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
  <li><a class="inactive" href="UserHome.jsp"><font size="5">Home</font></a></li>
  
		<li><a href="Searchforcandidate.jsp"><font size="5">Search for Candidate</font></a></li>
 		<li><a href="Searchmyhistoryservlet"><font size="5">View MySearch History</font></a></li>
 		<li><a href="Phraseminingservlet"><font size="5">View MyPhrase Mining</font></a></li> 		
  		<li><a href="Viewuserprofileservlet"><font size="5">View Profile</font></a></li>
  		<li><a href="changepassword.jsp"><font size="5">Security</font	></a></li>
  		<li><a href="Logout.jsp"><font size="5">Logout</font></a></li>  		 
  
</ul>
</body>
</html>
