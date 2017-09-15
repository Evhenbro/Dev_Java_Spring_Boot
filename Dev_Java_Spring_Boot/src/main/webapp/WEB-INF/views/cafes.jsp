<%@ include file="header.jsp"%>
	<div class="container mt-3">
		<div class="row">
			<div class="col-12">
				<form:form action="/admin/cafes" method="POST" modelAttribute="cafe">
					<div class="form-group row">
						<label class="col-2 col-form-label" for="name">Name:</label>
						<div class="col-10">
							<form:input class="form-control" id="name" path="name"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="address">Address:</label>
						<div class="col-10">
							<form:input class="form-control badge-pill" id="address" path="address"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="email">Email:</label>
						<div class="col-10">
							<form:input class="form-control" id="email" path="email"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="phone">Phone:</label>
						<div class="col-10">
							<form:input class="form-control" id="phone" path="phone"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="rate">Rate:</label>
						<div class="col-10">
							<form:input class="form-control" id="rate" path="rate"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="shortDescription">Short Description:</label>
						<div class="col-10">
							<form:textarea class="form-control" id="shortDescription" path="shortDescription" rows="3"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="fullDescription">Full Description:</label>
						<div class="col-10">
							<form:textarea class="form-control" id="fullDescription" path="fullDescription" rows="5"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="photoUrl">Photo Url:</label>
						<div class="col-10">
							<form:input class="form-control" id="photoUrl" path="photoUrl"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="version">Version:</label>
						<div class="col-10">
							<form:input class="form-control" id="version" path="version"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="type">Type:</label>
						<div class="col-10">
							<form:select class="form-control" path="type" items="${types}"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="open">Open:</label>
						<div class="col-10">
							<form:select class="form-control" path="open" items="${times}"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="close">Close:</label>
						<div class="col-10">
							<form:select class="form-control" path="close" items="${times}"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-10 mr-left">
							<button class="btn btn-sm btn-outline-success">Save</button>
							<a href="/admin/cafes/cancel" class="btn btn-sm btn-outline-info">Cancel</a>
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
						<th class="text-center">Address</th>
						<th class="text-center">Email</th>
						<th class="text-center">Phone</th>
						<th class="text-center">Rate</th>
						<th class="text-center">Short desc.</th>
						<th class="text-center">Full desc.</th>
						<th class="text-center">Photo Url</th>
						<th class="text-center">Version</th>
						<th class="text-center">Type</th>
						<th class="text-center">Open</th>
						<th class="text-center">Close</th>
						<th class="text-center">Options</th>
					</tr>
					<c:forEach var="fullCafe" items="${fullCafes}">
						<tr>
							<td>${fullCafe.name}</td>
							<td>${fullCafe.address}</td>
							<td>${fullCafe.email}</td>
							<td>${fullCafe.phone}</td>
							<td>${fullCafe.rate}</td>
							<td>${fullCafe.shortDescription}</td>
							<td>${fullCafe.fullDescription}</td>
							<td>${fullCafe.photoUrl}</td>
							<td>${fullCafe.version}</td>
							<td>${fullCafe.type}</td>
							<td>${fullCafe.open.time}</td>
							<td>${fullCafe.close.time}</td>
							<td class="text-center">
								<div>
									<a href="/admin/cafes/update/${fullCafe.id}" class="btn btn-outline-warning btn-sm">Update</a>
									<a href="/admin/cafes/delete/${fullCafe.id}" class="btn btn-outline-danger btn-sm"><i class="fa fa-trash-o" aria-hidden="true"></i> Delete</a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<%@ include file="footer.jsp"%>