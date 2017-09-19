<%@ include file="header.jsp"%>
	<div class="container mt-3">
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Name</th>
						<th class="text-center">Address</th>
						<th class="text-center">Rate</th>
						<th class="text-center">Type</th>
						<th class="text-center">Short desc.</th>
						<th class="text-center">Photo Url</th>
					</tr>
					<c:forEach var="cafe" items="${ownCafes}">
						<tr>
							<td><a href="/cafe/${cafe.id}">${cafe.name}</a></td>
							<td>${cafe.address}</td>
							<td>${cafe.rate}</td>
							<td>${cafe.type}</td>
							<td>${cafe.shortDescription}</td>
							<td><img src="/resources/cafe.jpg" class="img-fluid"></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
<%@ include file="footer.jsp"%>