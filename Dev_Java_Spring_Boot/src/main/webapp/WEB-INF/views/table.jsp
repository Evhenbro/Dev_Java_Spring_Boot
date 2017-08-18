<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<title>Table</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Count Of People</th>
						<th class="text-center">Free</th>
						<th class="text-center">Cafe</th>
						<th class="text-center">Options</th>
					</tr>
					<c:forEach var="table" items="${tables}">
						<tr>
							<td class="text-center">${table.countOfPeople}</td>
							<td class="text-center">${table.isFree}</td>
							<td class="text-center">${table.cafe}</td>
							<td class="text-center">
								<a href="/admin/table/update/${table.id}" type="button" class="btn btn-outline-success btn-sm">Update</a>
								<a href="/admin/table/delete/${table.id}" type="button" class="btn btn-outline-danger btn-sm">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>