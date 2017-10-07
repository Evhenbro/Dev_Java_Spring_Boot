<%@ include file="header.jsp"%>
	<hr class="bg-success">
	<div class="row align-items-end mt-3">
			<a href="/profile/meal/new" class="btn btn-outline-success btn-lg btn-block">Add new meal</a>			
		</div>
	<ul class="nav nav-pills mb-3 mt-3 justify-content-center">
		<li class="nav-item">
			<a class="nav-link" href="/profile/cafe">All own cafes</a>
		</li>
		<li class="nav-item">
			<a class="nav-link active" href="/profile/meal" role="tab">All own meals</a>
		</li>
	</ul>
	<hr class="bg-success">
	<div class="container mt-3">
		<div class="row">
			<div class="row col-4">
				<div class="col-12">
					<form:form action="/profile/meal" method="GET" modelAttribute="filterMeal">
						<div class="form-group row">
							<div class="col-12">
								<form:input class="form-control" path="search" placeholder="Search"/>
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
			
			
				
				<div class="col-8">
					<div class="col-12 mb-2">
						<div class="row">
							<div class="col-2 text-center ml-auto">
								<button class="dropdown-toggle btn btn-outline-primary btn-sm" type="button" data-toggle="dropdown">Sort</button>
								<div class="dropdown-menu">
									<custom:sort innerHtml="Name asc" paramValue="title"/>
									<custom:sort innerHtml="Name desc" paramValue="title,desc"/>
								</div>
							</div>
							<div class="col-2 text-center ml-auto">
								<custom:size posibleSizes="1,2,5,10" size="${ownMeals.size}" />
							</div>
						</div>
					</div>
					
					<c:forEach var="meal" items="${ownMeals.content}">
						<div class="border border-info rounded mb-2" style="background-color: rgba(206, 228, 93, 0.66);">
							<div class="row  m-1">
								<div class="col-6">
									<img src="/resources/food.jpeg" class="img-fluid">
								</div>
								<div class="col-6">
									<div class="row ml-1">
										<h3><a href="/meal/${meal.id}">${meal.title}</a></h3>
									</div>
									<p></p>
									<div class="row ml-1">
										<h5>Cuisine: ${meal.cuisine}</h5>
									</div>
									<p></p>
									<div class="row ml-1">
										<h5>Price: ${meal.price} UAN</h5>
									</div>
									<p></p>
									<div class="row ml-1">
										<h5>Cafe: ${meal.cafe}</h5>
									</div>
								</div>
							</div>
							<div class="row m-1 ml-3">
								<h6><p> 
									<c:forEach var="ingredient" items="${meal.ingredients}">
										${ingredient} 
									</c:forEach>							
								</p></h6>
							</div>
							<hr>
							<div class="row m-1 ml-3 d-flex justify-content-around mb-2">
								<a href="/profile/meal/update/${meal.id}" class="btn btn-warning btn-sm">Update</a>
								<a href="/profile/meal/delete/${meal.id}" class="btn btn-danger btn-sm"><i class="fa fa-trash-o" aria-hidden="true"></i> Delete</a>
							</div>
						</div>
					</c:forEach>
				</div>
		</div>
		<div class="row">
			<div class="col-12">
				<custom:pageable page="${ownMeals}"/>
			</div>	
		</div>
	</div>
	
	
	
	
	
	
	
	
	
	
	
	<%-- <div class="container">
		<div class="container mt-3">
			<div class="row">
				<div class="col-12">
					<form:form action="/profile/meal" method="GET" modelAttribute="filterMeal">
						
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
										<custom:size posibleSizes="1,2,5,10" size="${ownMeals.size}" />
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
		<div class="row align-items-end mt-3">
			<a href="/profile/meal/new" class="btn btn-outline-success btn-lg btn-block">Add new meal</a>			
		</div>
		<div class="row mt-3">
			<div class="col-12">
				<table class="table table-bordered">
					<tr >
						<th class="text-center">Title</th>
						<th class="text-center">Cuisine</th>
						<th class="text-center">Price</th>
						<th class="text-center">Cafe</th>
						<th class="text-center">Ingredients</th>
						<th class="text-center">Photo Url</th>
						<th class="text-center">Options</th>
					</tr>
					<c:forEach var="meal" items="${ownMeals.content}">
						<tr class="text-center">
							<td><a href="/meal/${meal.id}">${meal.title}</a></td>
							<td>${meal.cuisine}</td>
							<td>${meal.price} UAN</td>
							<td>${meal.cafe}</td>
							<td class="text-center">
								<c:forEach var="ingredient" items="${meal.ingredients}">
									${ingredient} 
								</c:forEach>
							</td>
							<td><img src="/resources/food.jpeg" class="img-fluid"></td>
							<td>
								<div>
									<a href="/profile/meal/update/${meal.id}" class="btn btn-outline-warning btn-sm">Update</a>
									<a href="/profile/meal/delete/${meal.id}" class="btn btn-outline-danger btn-sm"><i class="fa fa-trash-o" aria-hidden="true"></i> Delete</a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<custom:pageable page="${ownMeals}"/>
			</div>
		</div>
	</div> --%>
<%@ include file="footer.jsp"%>