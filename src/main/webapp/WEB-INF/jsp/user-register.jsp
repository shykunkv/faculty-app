<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../layouts/taglib.jsp" %>
    
    
   <c:if test="${param.success eq true}">
   		<div class = "alert alert-success">Registraion successfull</div>
   </c:if> 
    
<form:form commandName = "user" class = "form-horizontal">
	<div class = "form-group">
		<label for = "name" class = "col-sm-2 control-label">Name:</label>
		<div class="col-sm-10">
			<form:input path = "name" class = "form-control" />
    	</div>
	</div>
	<div class = "form-group">
		<label for = "email" class = "col-sm-2 control-label">Email:</label>
		<div class="col-sm-10">
			<form:input path = "email" class = "form-control" />
    	</div>
	</div>
	<div class = "form-group">
		<label for = "password" class = "col-sm-2 control-label">Password:</label>
		<div class="col-sm-10">
			<form:password path = "password" class = "form-control" />
    	</div>
	</div>
	
	<div class = "form-group">
		<div class="col-sm-10">
			<input type ="submit" value = "Save" class = "btn btn-lb btn-primary" />
    	</div>
	</div>
</form:form>   