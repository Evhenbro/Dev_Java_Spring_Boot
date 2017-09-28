<%@ include file="header.jsp"%>
	<div class="container mt-3">
		<div class="row">
			<div class="col-12">
				<form:form action="/profile/cafe" method="POST" modelAttribute="cafe">
					<div class="row">
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
						<label class="col-2 col-form-label" for="address">Address:</label>
						<div class="col-10">
							<form:input class="form-control" id="address" path="address"/>
						</div>
					</div>
					<div class="row">
						<div class="col-10 ml-auto" style="color: red;">
							<form:errors path="email"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="email">Email:</label>
						<div class="col-10">
							<form:input class="form-control" id="email" path="email"/>
						</div>
					</div>
					<div class="row">
						<div class="col-10 ml-auto" style="color: red;">
							<form:errors path="phone"/>
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
							<a href="/profile/cafe/new/cancel" class="btn btn-sm btn-outline-info">Cancel</a>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
<%@ include file="footer.jsp"%>