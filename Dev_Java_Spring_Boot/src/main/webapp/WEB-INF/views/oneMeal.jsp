<%@ include file="header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<div class="col">
					<h3>${mealById.title}</h3>
				</div>
				<div class="col-6">
					<img src="/resources/food.jpeg" class="img-fluid">
				</div>
				<div class="col">
					<h5>${mealById.cuisine}</h5>
					<br><h5>${mealById.price} UAN</h5>
					<br><h5>${mealById.cafe}</h5>
					<br><h5>${mealById.weight} gram</h5>
					<br><span>${mealById.description}</span>
				</div>
				<div class="col font-weight-bold">
					<c:forEach var="ingredient" items="${ingredients}">
						${ingredient}  
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
<%@ include file="footer.jsp"%>