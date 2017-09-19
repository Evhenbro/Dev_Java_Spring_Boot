<%@ include file="header.jsp"%>
	<div class="container">
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
						<th class="text-center">Options</th>
					</tr>
					<c:forEach var="meal" items="${ownMeals}">
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
	</div>
<%@ include file="footer.jsp"%>