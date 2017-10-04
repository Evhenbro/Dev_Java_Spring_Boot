<%@ include file="header.jsp"%>
	<div class="container">
		<div class="row align-items-end mt-3">
			<a href="/profile/cafe/new" class="btn btn-outline-success btn-lg btn-block">Add new cafe</a>			
		</div>
		<div class="container mt-3">
			<div class="row">
				<div class="col-12">
					<form:form action="/profile/cafe" method="GET" modelAttribute="cafeFilter">
						<div class="form-group row">
							<div class="col-6">
								<div class="form-group row">
									<div class="col-12">
										<form:input class="form-control" path="search" placeholder="Search"/>
									</div>
								</div>
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
										<custom:size posibleSizes="1,2,5,10" size="${ownCafes.size}" />
									</div>
								</div>
							</div>
						</div>
						
						<div class="form-group row">
							<div class="col-6">
								<form:input path="minRate" class="form-control" placeholder="Min rate"/>
							</div>
							<div class="col-6">
								<form:input path="maxRate" class="form-control" placeholder="Max rate"/>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-12">
								<div>
									<label>Pub <form:checkbox path="types" value="PUB"/></label>
									<label>Sushy <form:checkbox path="types" value="SUSHY"/></label>
									<label>Bar <form:checkbox path="types" value="BAR"/></label>
									<label>Cafe <form:checkbox path="types" value="CAFE"/></label>
									<label>Restaurant <form:checkbox path="types" value="RESTAURANT"/></label>
								</div>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-6">
								<form:input path="minOpen" class="form-control" placeholder="Min open"/>
							</div>
							<div class="col-6">
								<form:input path="maxOpen" class="form-control" placeholder="Max open"/>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-6">
								<form:input path="minClose" class="form-control" placeholder="Min close"/>
							</div>
							<div class="col-6">
								<form:input path="maxClose" class="form-control" placeholder="Max close"/>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-12">
	        					<button type="submit" class="btn btn-outline-success btn-sm">Search</button>
	      					</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
		<div class="row  mt-3">
			<div class="col-12">
				<table class="table table-bordered ">
					<tr>
						<th class="text-center">Name</th>
						<th class="text-center">Address</th>
						<th class="text-center">Rate</th>
						<th class="text-center">Type</th>
						<th class="text-center">Short desc.</th>
						<th class="text-center">Photo Url</th>
						<th class="text-center">Options</th>
					</tr>
					<c:forEach var="cafe" items="${ownCafes.content}">
						<tr class="text-center">
							<td><a href="/cafe/${cafe.id}">${cafe.name}</a></td>
							<td>${cafe.address}</td>
							<td>${cafe.rate}</td>
							<td>${cafe.type}</td>
							<td>${cafe.shortDescription}</td>
							<td><img src="/resources/cafe.jpg" class="img-fluid"></td>
							<td>
								<div>
									<a href="/profile/cafe/update/${cafe.id}" class="btn btn-outline-warning btn-sm">Update</a>
									<a href="/profile/cafe/delete/${cafe.id}" class="btn btn-outline-danger btn-sm"><i class="fa fa-trash-o" aria-hidden="true"></i> Delete</a>
									<a href="/profile/cafe/${cafe.id}/tables" class="btn btn-outline-danger btn-sm">Table</a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<custom:pageable page="${ownCafes}"/>
			</div>
		</div>
	</div>
<%@ include file="footer.jsp"%>