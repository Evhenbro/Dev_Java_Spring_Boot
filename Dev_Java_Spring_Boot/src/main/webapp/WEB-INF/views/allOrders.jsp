<%@ include file="header.jsp"%>
<div class = "container mt-3">
	<div class="row col-1 ml-auto mb-3">
		<custom:size posibleSizes="1,2,5,10" size="${cuisines.size}" />
	</div>
	<div class="row" >
		<div class = "col-12">
			<table class= "table table-bordered">
				<tr>
					<th class = "text-center">Table</th>
					<th class = "text-center">Title</th>
					<th class = "text-center">Price</th>
					<th class = "text-center">Weight</th>
					<th class = "text-center">Cafe</th>
					<th class = "text-center">Ingredients</th>
					<th class = "text-center">Option</th>
				</tr>
					<c:forEach var="meal" items="${cafeMeals.content}">
					<tr>
						<td>#${cafeTable.number}</td>
						<td>${meal.title}</td>
						<td>${meal.price}</td>
						<td>${meal.weight}</td>
						<td>${meal.cafe}</td>
						<td>
							<c:forEach var="ingredient" items="${meal.ingredients}">
								${ingredient} 
							</c:forEach>
						</td>
						<td class = "text-center">
							<a href = "/profile/cafe/${cafeId}/tables/${cafeTable.id}/order/${meal.id}"  class="btn btn-outline-danger btn-sm">Make order</a>
						</td>
					</tr>
					</c:forEach>
			</table>
		</div>
	
	</div>
	<div class="row">
 		<div class="col-12 text-center">
 			<custom:pageable page="${cafeMeals}"/>
 		</div>
 	</div>
</div>
<%@ include file="footer.jsp"%>