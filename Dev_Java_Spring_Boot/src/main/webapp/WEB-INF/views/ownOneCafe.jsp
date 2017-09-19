<%@ include file="header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-12 rounded border border-info">
				<div class="col">
					<h3>${cafeById.name}</h3>
				</div>
				<div class="col-6">
					<img src="/resources/cafe.jpg" class="img-fluid">
				</div>
				<div class="col">
					<h5>${cafeById.type}</h5>
					<br><h5>${cafeById.rate}</h5>
					<br><h5>${cafeById.address}</h5>
					<br><h5>${cafeById.phone}</h5>
					<br><h5>${cafeById.email}</h5>
					<br><span>${cafeById.fullDescription}</span>
					<br><strong>${cafeById.open} - ${cafeById.close}</strong>
				</div>
			</div>
		</div>
	</div>
<%@ include file="footer.jsp"%>