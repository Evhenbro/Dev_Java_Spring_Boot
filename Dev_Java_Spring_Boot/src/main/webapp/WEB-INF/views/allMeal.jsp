<%@ include file="header.jsp"%>
	<div class="container mt-3">
		<div class="row">
			<div class="col-6">
				<form:form action="/meal" method="GET" modelAttribute="filter">
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
							<custom:sort innerHtml="Title asc" paramValue="title"/>
							<custom:sort innerHtml="Title desc" paramValue="title,desc"/>
						</div>
					</div>
					<div class="col-2 text-center ml-auto">
						<custom:size posibleSizes="1,2,5,10" size="${meals.size}" />
					</div>
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
							<td>${meal.cuisine.name}</td>
							<td>${meal.price} UAN</td>
							<td>${meal.cafe.name}</td>
							<td>
								<c:forEach var="ingredient" items="${meal.ingredients}">
									${ingredient.name} 
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