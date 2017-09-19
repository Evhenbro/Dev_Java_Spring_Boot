<%@ include file="header.jsp"%>
	<div class="container">
		<div class="row align-items-end mt-3">
			<a href="/profile/cafe/new" class="btn btn-outline-success btn-lg btn-block">Add new cafe</a>			
		</div>
		<div class="row  mt-3">
			<div class="col-12">
				<table class="table table-bordered ">
					<tr>
						<th class="text-center">Name</th>
						<th class="text-center">Address</th>
						<th class="text-center">Rate</th>
						<th class="text-center">Type</th>
						<th class="text-center">Short desc.</th>
						<th class="text-center">Photo Url</th>
						<th class="text-center">Options</th>
					</tr>
					<c:forEach var="cafe" items="${ownCafes}">
						<tr class="text-center">
							<td><a href="/cafe/${cafe.id}">${cafe.name}</a></td>
							<td>${cafe.address}</td>
							<td>${cafe.rate}</td>
							<td>${cafe.type}</td>
							<td>${cafe.shortDescription}</td>
							<td><img src="/resources/cafe.jpg" class="img-fluid"></td>
							<td>
								<div>
									<a href="/profile/cafe/update/${cafe.id}" class="btn btn-outline-warning btn-sm">Update</a>
									<a href="/profile/cafe/delete/${cafe.id}" class="btn btn-outline-danger btn-sm"><i class="fa fa-trash-o" aria-hidden="true"></i> Delete</a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
<%@ include file="footer.jsp"%>