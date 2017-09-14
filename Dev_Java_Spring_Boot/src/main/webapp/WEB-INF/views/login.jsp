<%@ include file="header.jsp"%>
	<div class="container mt-3">
		<div class="row">
			<div class="col-12">
				<form:form action="/login" method="POST">
					<div class="form-group row">
						<label class="col-2 col-form-label" for="login">Login:</label>
						<div class="col-10">
							<input class="form-control" id="login" name="login"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="password">Password:</label>
						<div class="col-10">
							<input class="form-control" type="password" id="password" name="password"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-10 ml-auto">
							<label><input name="rememberMe" type="checkbox">Remember me</label>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-10 ml-auto">
							<button class="btn btn-sm btn-outline-success">Sign in</button>
							<a href="/registration" class="btn btn-sm btn-outline-primary">Registration</a>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
<%@ include file="footer.jsp"%>