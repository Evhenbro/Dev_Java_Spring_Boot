<%@ include file="header.jsp"%>
	<div class="text-center">
		<h4 class="text-primary">THERE YOU CAN ADD OR UPDATE CUISINE</h4>
	</div>
	<div class="container mt-3">
		<div class="row">
			<div class="col-12">
				<form:form action="/admin/cuisine" method="POST" modelAttribute="cuisine">
					<div class="form-group row">
						<label class="col-2 col-form-label" for="name">Name:</label>
						<div class="col-10">
							<form:input class="form-control" id="name" path="name"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-10 ml-auto">
							<button class="btn btn-sm btn-outline-success">Save</button>
							<a href="/admin/cuisine/cancel" class="btn btn-sm btn-outline-info">Cancel</a>
						</div>
					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Name</th>
						<th class="text-center">Options</th>
					</tr>
					<c:forEach var="cuisine" items="${cuisines}">
						<tr>
							<td>${cuisine.name}</td>
							<td class="text-center">
								<a href="/admin/cuisine/update/${cuisine.id}" class="btn btn-sm btn-outline-warning">Update</a>
								<a href="/admin/cuisine/delete/${cuisine.id}" class="btn btn-sm btn-outline-danger">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
<%@ include file="footer.jsp"%>