<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "../layouts/taglib.jsp" %>
    
    
  
    <table class = "table table-bordered table-hover">
    	<thead>
    		<tr>
    			<th>Group name</th>
    			<th>Students in group</th>
    			<th>Course of study</th>
    			<th  style = "width:15%"></th>
    		</tr>
    	</thead>
    	<tbody>
    		<c:forEach items = "${groups}" var= "group">
    			<tr>
    				<td>
    					${group.name}
    				</td>
    				<td>
    					${group.studentsNum }
    				</td>
    				<td>
    					${group.year }
    				</td>
    				<td>
    				<security:authorize access = "hasRole('ROLE_ADMIN')">  
    				<a href = '<spring:url value ="groups/remove/${group.id }.html" />' class = "btn btn-danger">Delete group</a>
    				</security:authorize>
    				</td>
    			</tr>
    		</c:forEach>
    	</tbody>
    </table>
    
    
        <!-- Button trigger modal -->
<security:authorize access = "hasRole('ROLE_ADMIN')">        
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
 	Add new group
</button>
</security:authorize>

<form:form commandName = "newgroup" class = "form-horizontal">
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">New group</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Name:</label>
						<div class="col-sm-10">
							<form:input path="name" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label for="year" class="col-sm-2 control-label">Course:</label>
						<div class="col-sm-10">
							<form:input path="year" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label for="studentsNum" class="col-sm-2 control-label">Number
							of students:</label>
						<div class="col-sm-10">
							<form:input path="studentsNum" class="form-control" />
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<input type = "submit" class="btn btn-primary" value = "Save"/>
				</div>
			</div>
		</div>
	</div>
</form:form>


<%-- <security:authorize access = "hasRole('ROLE_ADMIN')">
    	<a class="btn btn-default" href="/add-group.html" role="button">Add new group</a>
    </security:authorize>
     --%>
