<%@ include file="header.jsp"%>
<div class = "container mt-3">
	<div class="row col-1 ml-auto mb-3">
		<custom:size posibleSizes="1,2,5,10" size="${orders.size}" />
	</div>
	<div class="row" >
		<div class = "col-12">
			<table class= "table table-bordered">
				<tr>
					<th class = "text-center">Cafe</th>
					<th class = "text-center">Table</th>
					<th class = "text-center">Meals</th>
					<th class = "text-center">Total price</th>
					<th class = "text-center">Status</th>
					<th class = "text-center">Option</th>
				</tr>
					<c:forEach var="order" items="${orders.content}">
					<tr>
						<td>${thiscafe.name}</td>
						<td>#${order.table.number}</td>
						<td>
							<c:forEach var="meal" items="${order.meals}">
								${meal.title} 
							</c:forEach>
						</td>
						<td>${order.totalPrice}</td>
						<td>${order.status}</td>
						<td class = "text-center">
							<a href = "/profile/cafe/${cafeId}/tables/${tableId}/orders/ready/${order.id}"  class="btn btn-outline-danger btn-sm">Ready</a>
							<a href = "/profile/cafe/${cafeId}/tables/${tableId}/orders/accepted/${order.id}"  class="btn btn-outline-danger btn-sm">Accepted</a>
							<a href = "/profile/cafe/${cafeId}/tables/${tableId}/orders/paid/${order.id}"  class="btn btn-outline-danger btn-sm">Paid</a>
						</td>
					</tr>
					</c:forEach>
			</table>
		</div>
	
	</div>
	<div class="row">
 		<div class="col-12 text-center">
 			<custom:pageable page="${orders}"/>
 		</div>
 	</div>
</div>
<%@ include file="footer.jsp"%>