<%@ include file="header.jsp"%>
	<div class="text-center">
		<h4 class="text-primary">THERE YOU CAN ADD OR UPDATE TIME</h4>
	</div>
	<div class="container mt-3">
		<div class="row">
			<div class="col-3">
				<form:form action="/admin/times" method="GET" modelAttribute="filter">
					<div class="form-group row">
						<div class="col-12">
							<form:input class="form-control" path="searchTime" placeholder="Search"/>
						</div>
					</div>
				</form:form>
			</div>
			<div class="col-9">
				<form:form action="/admin/times" method="POST" modelAttribute="open_close">
					<custom:hiddenInputs excludeParams="time, _csrf"/>
					<div class="row">
						<div class="col-10 ml-auto" style="color: red;">
							<form:errors path="time"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="time">Time:</label>
						<div class="col-10">
							<form:input class="form-control" id="time" path="time"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-10 ml-auto">
							<button class="btn btn-sm btn-outline-success">Save</button>
							<a href="/admin/times/cancel<custom:allParams/>" class="btn btn-sm btn-outline-info">Cancel</a>
						</div>
					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-9">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Time</th>
						<th class="text-center">Options</th>
					</tr>
					<c:forEach var="time" items="${times.content}">
						<tr>
							<td>${time.time}</td>
							<td class="text-center">
								<a href="/admin/times/update/${time.id}<custom:allParams/>" class="btn btn-sm btn-outline-warning">Update</a>
								<a href="/admin/times/delete/${time.id}<custom:allParams/>" class="btn btn-sm btn-outline-danger">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="col-3">
				<div class="row">
					<div class="col-6 text-center">
						<button class="dropdown-toggle btn btn-outline-primary btn-sm" type="button" data-toggle="dropdown">Sort</button>
						<div class="dropdown-menu">
							<custom:sort innerHtml="Time asc" paramValue="time"/>
							<custom:sort innerHtml="Time desc" paramValue="time,desc"/>
						</div>
					</div>
					<div class="col-6 text-center">
						<custom:size posibleSizes="1,2,5,10" size="${times.size}" />
					</div>
				</div>
			</div>
		</div>
		<div class="row">
 			<div class="col-12">
 				<custom:pageable page="${times}"/>
 			</div>
 		</div>
	</div>
<%@ include file="footer.jsp"%>