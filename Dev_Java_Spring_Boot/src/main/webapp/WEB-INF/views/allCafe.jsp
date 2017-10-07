<%@ include file="header.jsp"%>
	<hr class="bg-success">
	<ul class="nav nav-pills mb-3 mt-3 justify-content-center">
		<li class="nav-item">
			<a class="nav-link active" href="/cafe">All cafes</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="/meal" role="tab">All meals</a>
		</li>
	</ul>
	<hr class="bg-success">
	<div class="container mt-3">
		<div class="row">
			<div class="row col-4">
				<div class="col-12">
					<form:form action="/cafe" method="GET" modelAttribute="cafeFilter">
						<div class="form-group row">
							<div class="col-12">
								<form:input class="form-control" path="search" placeholder="Search"/>
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
									<label>Type: </label>
								</div>
								<div>
									<label>Pub <form:checkbox path="types" value="PUB"/></label>
								</div>
								<div>
									<label>Sushy <form:checkbox path="types" value="SUSHY"/></label>
								</div>
								<div>
									<label>Bar <form:checkbox path="types" value="BAR"/></label>
								</div>
								<div>
									<label>Cafe <form:checkbox path="types" value="CAFE"/></label>
								</div>
								<div>
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
						<%-- <div class="form-group row">
							<div class="col-12">
								<form:checkboxes items="${meals}" path="mealsIds" element="div" itemLabel="title" itemValue="id"/>
							</div>
						</div> --%>
						<div class="form-group row">
							<div class="col-12">
	        					<button type="submit" class="btn btn-outline-success btn-sm">Search</button>
	      					</div>
						</div>
					</form:form>
				</div>
			</div>
		
			<div class="col-8">
				<div class="col-12 mb-2">
					<div class="row">
						<div class="col-2 text-center ml-auto">
							<button class="dropdown-toggle btn btn-outline-primary btn-sm" type="button" data-toggle="dropdown">Sort</button>
							<div class="dropdown-menu">
								<custom:sort innerHtml="Name asc" paramValue="name"/>
								<custom:sort innerHtml="Name desc" paramValue="name,desc"/>
							</div>
						</div>
						<div class="col-2 text-center ml-auto">
							<custom:size posibleSizes="1,2,5,10" size="${cafes.size}" />
						</div>
					</div>
				</div>
				
				<c:forEach var="cafe" items="${cafes.content}">
					<div class="border border-info rounded mb-2" style="background-color: rgba(206, 228, 93, 0.66);">
						<div class="row  m-1">
							<div class="col-6">
								<img src="/resources/cafe.jpg" class="img-fluid">
							</div>
							<div class="col-6">
								<div class="row ml-1">
									<h3><a href="/cafe/${cafe.id}">${cafe.name}</a></h3>
								</div>
								<br>
								<div class="row ml-1">
									<h5>Type: ${cafe.type}</a></h5>
								</div>
								<br>
								<div class="row ml-1">
									<h4><i class="fa fa-area-chart" aria-hidden="true"></i> Rate</h4>
								</div>
								<div class=" row ml-1 progress" style="width: 80%">
									<div class="progress-bar bg-success" role="progressbar" style="width: ${cafe.rate*10}%" aria-valuenow="${cafe.rate}" aria-valuemin="0" aria-valuemax="10">${cafe.rate}</div>
								</div>
								<br>
								<div class="row ml-1">
									<h5 class="text-dark font-italic"><i class="fa fa-map-marker" aria-hidden="true"></i> Address: ${cafe.address}</h5>
								</div>
							</div>
						</div>
						<div class="row m-1 ml-3">
							<h6><p> ${cafe.shortDescription}</p></h6>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="row">
 			<div class="col-12">
 				<custom:pageable page="${cafes}"/>
 			</div>
 		</div>
	</div>
<%@ include file="footer.jsp"%>