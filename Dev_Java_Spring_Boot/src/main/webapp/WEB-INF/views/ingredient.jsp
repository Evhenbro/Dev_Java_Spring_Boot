<%@ include file="header.jsp"%>
	<div class="text-center">
		<h4 class="text-primary">THERE YOU CAN ADD OR UPDATE INGREDIENTS</h4>
	</div>
	<div class="container mt-3">
		<div class="row">
			<div class="col-12">
				<form:form action="/admin/ingredient" method="POST" modelAttribute="ingredient">
					<div class="form-group row">
						<div class="col-10 ml-auto" style="color: red;">
							<form:errors path="name"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="name">Name:</label>
						<div class="col-10">
							<form:input class="form-control" id="name" path="name"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-10 ml-auto">
							<button class="btn btn-sm btn-outline-success">Save</button>
							<a href="/admin/ingredient/cancel" class="btn btn-sm btn-outline-info">Cancel</a>
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
					<c:forEach var="ingredient" items="${ingredients.content}">
						<tr>
							<td>${ingredient.name}</td>
							<td class="text-center">
								<a href="/admin/ingredient/update/${ingredient.id}" class="btn btn-outline-success btn-sm">Update</a>
								<a href="/admin/ingredient/delete/${ingredient.id}" class="btn btn-outline-danger btn-sm">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<custom:pageable page="${ingredients}"/>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>