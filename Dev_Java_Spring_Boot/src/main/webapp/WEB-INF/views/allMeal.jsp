<%@ include file="header.jsp"%>
	<ul class="nav nav-pills mb-3 mt-3 justify-content-center">
		<li class="nav-item">
			<a class="nav-link" href="/cafe">All cafes</a>
		</li>
		<li class="nav-item">
			<a class="nav-link active" href="/meal" role="tab">All meals</a>
		</li>
	</ul>
	<div class="container mt-3">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<form:form action="/meal" method="GET" modelAttribute="filterMeal">
						
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
											<custom:sort innerHtml="Name asc" paramValue="title"/>
											<custom:sort innerHtml="Name desc" paramValue="title,desc"/>
										</div>
									</div>
									<div class="col-2 text-center ml-auto">
										<custom:size posibleSizes="1,2,5,10" size="${meals.size}" />
									</div>
								</div>
							</div>
						</div>
						
						<div class="form-group row">
							<div class="col-6">
								<form:input path="minPrice" class="form-control" placeholder="Min price"/>
							</div>
							<div class="col-6">
								<form:input path="maxPrice" class="form-control" placeholder="Max price"/>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-12">
								<form:select items="${cafes}" path="cafeId" element="div" itemLabel="name" itemValue="id"/>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-12">
								<form:checkboxes items="${cuisines}" path="cuisineId" element="div" itemLabel="name" itemValue="id"/>
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
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Title</th>
						<th class="text-center">Cuisine</th>
						<th class="text-center">Price</th>
						<th class="text-center">Cafe</th>
						<th class="text-center">Ingredients</th>
						<th class="text-center">Photo Url</th>
					</tr>
					<c:forEach var="meal" items="${meals.content}">
						<tr>
							<td><a href="/meal/${meal.id}">${meal.title}</a></td>
							<td>${meal.cuisine}</td>
							<td>${meal.price} UAN</td>
							<td>${meal.cafe}</td>
							<td>
								<c:forEach var="ingredient" items="${meal.ingredients}">
									${ingredient} 
								</c:forEach>
							</td>
							<td><img src="/resources/food.jpeg" class="img-fluid"></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<custom:pageable page="${meals}"/>
			</div>	
		</div>
	</div>
<%@ include file="footer.jsp"%>