<%@ include file="header.jsp"%>
	<div class="container mt-3">
		<div class="row">
			<div class="col-6">
				<form:form action="/cafe" method="GET" modelAttribute="filter">
					<div class="form-group row">
						<div class="col-12">
							<form:input class="form-control" path="search" placeholder="Search"/>
						</div>
					</div>
				</form:form>
			</div>
			<div class="col-6">
				<div class="row">
					<div class="col-2 text-center ml-auto">
						<button class="dropdown-toggle btn btn-outline-primary btn-sm" type="button" data-toggle="dropdown">Sort</button>
						<div class="dropdown-menu">
							<custom:sort innerHtml="Name asc" paramValue="name"/>
							<custom:sort innerHtml="Name desc" paramValue="name,desc"/>
						</div>
					</div>
					<div class="col-2 text-center ml-auto">
						<custom:size posibleSizes="1,2,5,10" size="${cafeShortView.size}" />
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Name</th>
						<th class="text-center">Address</th>
						<th class="text-center">Rate</th>
						<th class="text-center">Type</th>
						<th class="text-center">Short desc.</th>
						<th class="text-center">Photo Url</th>
					</tr>
					<c:forEach var="cafe" items="${cafeShortView.content}">
						<tr  class="text-center">
							<td><a href="/cafe/${cafe.id}">${cafe.name}</a></td>
							<td>${cafe.address}</td>
							<td>${cafe.rate}</td>
							<td>${cafe.type}</td>
							<td>${cafe.shortDescription}</td>
							<td><img src="/resources/cafe.jpg" class="img-fluid"></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="row">
 			<div class="col-12">
 				<custom:pageable page="${cafeShortView}"/>
 			</div>
 		</div>
	</div>
<%@ include file="footer.jsp"%>