<%@ include file="header.jsp"%>
	<div class="container mt-3">
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Number</th>
						<th class="text-center">Count Of People</th>
						<th class="text-center">Free</th>
						<th class="text-center">Cafe</th>
						<th class="text-center">Options</th>
					</tr>
					<c:forEach var="table" items="${tables}">
						<tr>
							<td>#${table.number}</td>
							<td>${table.countOfPeople}</td>
							<td>${table.isFree}</td>
							<td>${table.cafe}</td>
							<td class="text-center">
								<c:if test="${table.isFree.equals(true)}">
									<a href="/cafe/${cafe.id}/tables/${table.id}" class="btn btn-outline-success btn-sm">Reserve</a>
								</c:if>
								<c:if test="${table.isFree.equals(false)}">
									<!-- <button class="btn btn-outline-danger btn-sm">Ups...</button> --> 
									<span class="text-danger font-italic"> The table is reserved!</span> 
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
<%@ include file="footer.jsp"%>