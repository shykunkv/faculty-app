<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "../layouts/taglib.jsp" %>
    
    
    
    
  
    <table class = "table table-bordered table-hover">
    	<thead>
    		<tr>
    			<th>Lesson</th>
    			<th>Teacher</th>
    			<th>Group</th>
    			<th>Hours per week</th>
    			<th  style = "width:15%"></th>
    		</tr>
    	</thead>
    	<tbody>
    		<c:forEach items = "${pairs}" var= "pair">
    			<tr>
    				<td>
    					${pair.lessonName}
    					
    				</td>
    				<td>
    					${pair.teacherName}
    				</td>
    				<td>
    					${pair.groupName}
    				</td>
    				<td>
    					${pair.hours}
    				</td>
    				<td>
    				<security:authorize access = "hasRole('ROLE_ADMIN')">  
    				<a href = '<spring:url value ="pairs/remove/${pair.id }.html" />' class = "btn btn-danger">Delete pair</a>
    				</security:authorize>
    				</td>
    			</tr>
    		</c:forEach>
    	</tbody>
    </table>
    
    
        <!-- Button trigger modal -->
<security:authorize access = "hasRole('ROLE_ADMIN')">        
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
 	Add new pair
</button>
</security:authorize>

<form:form commandName = "newpair" class = "form-horizontal">
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
					<h4 class="modal-title" id="myModalLabel">New pair</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="lessonName" class="col-sm-2 control-label">Lesson:</label>
						<div class="col-sm-10">
							<%-- <form:input path="lessonName" class="form-control" /> --%>
							<form:select path="lessonName" class = "form-control">
   								<form:options items="${lessons}" />
							</form:select>
						</div>
					</div>
					<div class="form-group">
						<label for="teacherName" class="col-sm-2 control-label">Teacher:</label>
						<div class="col-sm-10">
							<%-- <form:input path="teacherName" class="form-control" /> --%>
							<form:select path="teacherName" class = "form-control">
   								<form:options items="${teachers}" />
							</form:select>
						</div>
					</div>
					<div class="form-group">
						<label for="groupName" class="col-sm-2 control-label">Group:</label>
						<div class="col-sm-10">
							<%-- <form:input path="groupName" class="form-control" /> --%>
							<form:select path="groupName" class = "form-control">
   								<form:options items="${groups}" />
							</form:select>
						</div>
					</div>
					
					<div class="form-group">
						<label for="hours" class="col-sm-2 control-label">Hours per week:</label>
						<div class="col-sm-10">
							<form:input path="hours" class="form-control" />
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
