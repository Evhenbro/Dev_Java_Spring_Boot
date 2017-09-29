<%@ include file="header.jsp"%>
	<div class="container mt-3">
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