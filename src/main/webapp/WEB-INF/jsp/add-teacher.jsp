<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "../layouts/taglib.jsp" %>
    
<form:form commandName = "newteacher" class = "form-horizontal">
 	<div class = "form-group">
		<label for = "name" class = "col-sm-2 control-label">Name:</label>
		<div class="col-sm-10">
			<form:input path = "name" class = "form-control" />
    	</div>
	</div>
 	<div class = "form-group">
		<label for = "degree" class = "col-sm-2 control-label">Teacher degree:</label>
		<div class="col-sm-10">
			<form:input path = "degree" class = "form-control" />
    	</div>
	</div>
	<div class = "form-group">
		<div class="col-sm-10">
			<input type ="submit" value = "Save" class = "btn btn-lb btn-primary" />
    	</div>
	</div>
</form:form>  