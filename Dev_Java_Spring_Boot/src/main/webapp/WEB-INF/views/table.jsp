<%@ include file="header.jsp"%>
	<div class="container mt-3">
		<div class="row">
			<div class="col-12">
				<form:form action="/profile/cafe/${cafe.id}/tables" method="POST" modelAttribute="table">
					<div class="form-group row">
						<label class="col-2 col-form-label" for="number">Number:</label>
						<div class="col-10">
							<form:input class="form-control" id="number" path="number"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="countOfPeople">Count Of People:</label>
						<div class="col-10">
							<form:input class="form-control" id="countOfPeople" path="countOfPeople"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-4 form-check">
							<form:checkbox path="IsFree"/>
							<label class="form-check-label pl-2">
								Free
							</label>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="cafe">Cafe:</label>
						<div class="col-10">
						<input type="hidden" id="cafe" name="${onecafe.name}" value="${onecafe.name}"/>
						<%-- <form:hidden path="cafe" value="${onecafe.id}"/> --%> 
						<%-- <form:select class="form-control" path="cafe" items="${ownCafes}" itemValue="name" itemLabel="name"/> --%>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-10 ml-auto">
							<button class="btn btn-sm btn-outline-success">Save</button>
							<a href="/profile/cafe/${cafe.id}/tables/cancel" class="btn btn-sm btn-outline-info">Cancel</a>
						</div>
					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Number</th>
						<th class="text-center">Count Of People</th>
						<th class="text-center">Free</th>
						<th class="text-center">Cafe</th>
						<th class="text-center">User</th>
						<th class="text-center">User phone</th>
						<th class="text-center">Options</th>
					</tr>
					<c:forEach var="table" items="${tables}">
						<tr>
							<td>${table.number}</td>
							<td>${table.countOfPeople}</td>
							<td>${table.isFree}</td>
							<td>${table.cafe}</td>
							<td>${table.user}</td>
							<td>${table.userPhone}</td>
							<td class="text-center">
								<a href="/profile/cafe/${cafe.id}/tables/update/${table.id}" class="btn btn-outline-success btn-sm">Update</a>
								<a href="/profile/cafe/${cafe.id}/tables/delete/${table.id}" class="btn btn-outline-danger btn-sm">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
<%@ include file="footer.jsp"%>