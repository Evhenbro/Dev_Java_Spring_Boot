<%@ include file="header.jsp"%>
	<div class="container mt-3">
		<br>
		<div class="row">
			<div class="col-12">
				<form:form action="/registration" method="POST" modelAttribute="registration">
					<div class="form-group row">
						<label class="col-2 col-form-label" for="login">Login:</label>
						<div class="col-10">
							<form:input class="form-control" id="login" path="login"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="password">Password:</label>
						<div class="col-10">
							<form:password class="form-control" id="password" path="password"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="repeatPassword">Repeat Password:</label>
						<div class="col-10">
							<form:password class="form-control" id="repeatPassword" path="repeatPassword"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-10 ml-auto">
							<button class="btn btn-sm btn-outline-success">Register</button>
							<a href="/login" class="btn btn-sm btn-outline-primary">Login</a>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
<%@ include file="footer.jsp"%>