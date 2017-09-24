<%@ include file="header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-12 rounded border border-info">
				<div class="col">
					<h3>${cafeById.name}</h3>
				</div>
				<div class="col-6">
					<img src="/resources/cafe.jpg" class="img-fluid">
				</div>
				<div class="col">
					<h5>${cafeById.type}</h5>
					<br><h5>${cafeById.rate}</h5>
					<br><h5>${cafeById.address}</h5>
					<br><h5>${cafeById.phone}</h5>
					<br><h5>${cafeById.email}</h5>
					<br><span>${cafeById.fullDescription}</span>
					<br><strong>${cafeById.open} - ${cafeById.close}</strong>
				</div>
				<div class="col-2 ml-auto my-2">
					<a href="/cafe/${cafeById.id}/tables" class="btn btn-sm btn-outline-success">To order a table</a>
				</div>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-12 rounded border border-info">
				<form:form action="/cafe/${cafeById.id}" method="POST" modelAttribute="comment">
					<div class="form-group row mt-3">
						<label class="col-2 col-form-label" for="user">User:</label>
						<div class="col-10">
							<form:input class="form-control" id="user" path="user"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="rate">Rate:</label>
						<div class="col-10">
							<form:input class="form-control" id="rate" path="rate"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="message">Message:</label>
						<div class="col-10">
							<form:textarea class="form-control" id="message" path="message" rows="4"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-10 ml-auto">
							<button class="btn btn-sm btn-outline-success">Save</button>
							<a href="/cafe/${cafeById.id}/cancel" class="btn btn-sm btn-outline-info">Cancel</a>
						</div>
					</div>
				</form:form>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-12 rounded border border-info">
				<table class="table table-bordered mt-3">
					<tr>
						<th class="text-center">User</th>
						<th class="text-center">Time</th>
						<th class="text-center">Rate</th>
						<th class="text-center">Message</th>
					</tr>
					<c:forEach var="comment" items="${comments}">
						<tr>
							<td>${comment.user}</td>
							<td>${comment.time}</td>
							<td>${comment.rate}</td>
							<td>${comment.message}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
<%@ include file="footer.jsp"%>