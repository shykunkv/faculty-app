<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "../layouts/taglib.jsp" %>
    
<form:form commandName = "newgroup" class = "form-horizontal">
 	<div class = "form-group">
		<label for = "name" class = "col-sm-2 control-label">Name:</label>
		<div class="col-sm-10">
			<form:input path = "name" class = "form-control" />
    	</div>
	</div>
 	<div class = "form-group">
		<label for = "year" class = "col-sm-2 control-label">Course:</label>
		<div class="col-sm-10">
			<form:input path = "year" class = "form-control" />
    	</div>
	</div>
	<div class = "form-group">
		<label for = "studentsNum" class = "col-sm-2 control-label">Number of students:</label>
		<div class="col-sm-10">
			<form:input path = "studentsNum" class = "form-control" />
    	</div>
	</div> 
	<div class = "form-group">
		<div class="col-sm-10">
			<input type ="submit" value = "Save" class = "btn btn-lb btn-primary" />
    	</div>
	</div>
</form:form>  