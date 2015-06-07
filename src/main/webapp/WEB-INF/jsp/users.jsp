<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ include file = "../layouts/taglib.jsp" %>
    
    <table class = "table table-bordered table-hover">
    	<thead>
    		<tr>
    			<th>User name</th>
    			<th>Roles</th>
    		</tr>
    	</thead>
    	<tbody>
    		<c:forEach items = "${users}" var= "user">
    			<tr>
    				<td>
    					${user.name}
    				</td>
    				<td>
    				<c:forEach items = "${ user.roles}" var = "role">	
    					
    					<li>	${role.name} </li>
    					
    				</c:forEach>
    				</td>
    			</tr>
    		</c:forEach>
    	</tbody>
    </table>
    