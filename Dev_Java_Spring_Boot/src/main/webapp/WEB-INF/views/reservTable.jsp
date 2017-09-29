<%@ include file="header.jsp"%>
	<div class="container mt-3">
		<div class="row">
			<div class="col-12">
				<form:form action="/cafe/${idCafe}/tables/${idTable}" method="POST" modelAttribute="reservTable">
					<div class="row">
						<div class="col-10 ml-auto" style="color: red;">
							<form:errors path="user"></form:errors>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="user">User:</label>
						<div class="col-10">
							<form:input class="form-control" id="user" path="user"/>
						</div>
					</div>
					<div class="row">
						<div class="col-10 ml-auto" style="color: red;">
							<form:errors path="userPhone"></form:errors>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="userPhone">User phone:</label>
						<div class="col-10">
							<form:input class="form-control" id="userPhone" path="userPhone"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-10 ml-auto">
							<button class="btn btn-sm btn-outline-success">Save</button>
							<a href="/cafe/${cafe.id}/tables/cancel" class="btn btn-sm btn-outline-info">Cancel</a>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
<%@ include file="footer.jsp"%>