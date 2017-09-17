<%@ include file="header.jsp"%>
	<div class="container mt-3">
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Name</th>
						<th class="text-center">Address</th>
						<th class="text-center">Rate</th>
						<th class="text-center">Short desc.</th>
						<th class="text-center">Photo Url</th>
						<th class="text-center">Type</th>
						<th class="text-center">Open</th>
						<th class="text-center">Close</th>
					</tr>
					<c:forEach var="fullCafe" items="${fullCafes}">
						<tr>
							<td>${fullCafe.name}</td>
							<td>${fullCafe.address}</td>
							<td>${fullCafe.rate}</td>
							<td>${fullCafe.shortDescription}</td>
							<td>${fullCafe.photoUrl}</td>
							<td>${fullCafe.type}</td>
							<td>${fullCafe.open.time}</td>
							<td>${fullCafe.close.time}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<%@ include file="footer.jsp"%>