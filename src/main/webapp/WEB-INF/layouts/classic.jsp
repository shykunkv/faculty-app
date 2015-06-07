<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "taglib.jsp" %>
    
    
<!DOCTYPE html>
<html>
<head>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">


<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name = "title"/></title>
</head>
<body>

<%@ taglib uri = "http://tiles.apache.org/tags-tiles-extras" prefix = "tilesx"  %>

	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">FACULTY SYSTEM</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href='<spring:url value ="/index.html"/>'>Home</a></li>
            
            <security:authorize access = "hasRole('ROLE_ADMIN')">
	        	<li><a href='<spring:url value ="/users.html"/>'>Users</a></li>
	        </security:authorize>
            
            <security:authorize access = "isAuthenticated()">
            	<li><a href='<spring:url value ="/groups.html"/>'>Groups</a></li>
	        	<li><a href='<spring:url value ="/lessons.html"/>'>Lessons</a></li>
            	<li><a href='<spring:url value ="/teachers.html"/>'>Teachers</a></li>
            	<li><a href='<spring:url value ="/pairs.html"/>'>Pairs</a></li>
            	<li><a href='<spring:url value ="/schedule.html"/>'>Schedule</a></li>
            </security:authorize>
            
            <security:authorize access = "! isAuthenticated()">
            	<li><a href='<spring:url value ="/register.html"/>'>Registration</a></li>
            	<li><a href='<spring:url value ="/login.html"/>'>Login</a></li>
            </security:authorize>
            <security:authorize access = "isAuthenticated()">
            	<li><a href='<spring:url value ="/logout"/>'>Logout</a></li>
            </security:authorize>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
	
	
	<div class="container">
      <div class="starter-template">
        <center>
        <p class="lead">
        	<br>
        	<br>
        	
			<tiles:insertAttribute name = "body"/>
			
		</p>
		</center>
      </div>
    </div>

	
	<br><br>
	
	<center>
		<tiles:insertAttribute name = "footer" />
	</center>
</body>
</html>