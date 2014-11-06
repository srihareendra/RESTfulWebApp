<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>RESTful To-do WebApp</title>
    <style>
	table.list
	{
		border-collapse:collapse;
		width: 40%;
	}
	table.list, table.list td, table.list th
	{
		border:1px solid gray;
		padding: 5px;
	}
	</style>
</head>
<body>
 
<h2>RESTFul To-do Web Application</h2>
 
<s:form method="post" action="add">
    <table>
	    <tr>
	        <td><s:textfield key="label.name" name="task.name"/></td> 
	    </tr>
	    <tr>
	        <td><s:textfield key="label.description" name="task.description"/></td>
	    </tr>
	    <tr>
	        <td><s:textfield key="label.priority" name="task.priority"/></td>
	    </tr>
	    <tr>
	        <td><s:textfield key="label.status" name="task.status"/></td>
	    </tr>
	    <tr>
	        <td>
	        	<s:submit key="label.addTask"></s:submit>
	        </td>
	    </tr>
	</table> 
</s:form>
 
     
<h3>To-do Tasks List</h3>
<c:if  test="${!empty tasks}">
	<table class="list">
		<tr>
		    <th align="left">Task Name</th>
		    <th align="left">Description</th>
		    <th align="left">Priority</th>
		    <th align="left">Status</th>
		</tr>
		<c:forEach items="${tasks}" var="tsk">
		    <tr>
		        <td>${tsk.name} </td>
		        <td>${tsk.description}</td>
		        <td>${tsk.priority}</td>
		        <td>${tsk.status}</td>
		        <td><a href="delete/${tsk.id}">delete</a></td>
		    </tr>
		</c:forEach>
	</table>
</c:if>
 
</body>
</html>