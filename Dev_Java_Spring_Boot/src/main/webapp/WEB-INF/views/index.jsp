<%@ include file="header.jsp"%>
<div class="container">
	<h2 class="text-center">${message}</h2>
	<div  class="mx-auto text-center mt-2">
		<h2 class="text-success">TOP 5 CAFES</h2>
	</div>
	<div class="mt-3">
		<c:forEach var="topFive" items="${topFives}">
			<div class="row mt-2">
				<div class="col-12 rounded border border-info">
					<div class="col">
						<h3><a href="/cafe/${topFive.id}">${topFive.name}</a></h3>
					</div>
					<div class="col-6">
						<img src="/resources/cafe.jpg" class="img-fluid">
					</div>
					<div class="col">
						<h5>${topFive.type}</h5>
						<div class="progress" style="width: 25%">
							<div class="progress-bar bg-success" role="progressbar" style="width: ${topFive.rate*10}%" aria-valuenow="${topFive.rate}" aria-valuemin="0" aria-valuemax="10">${topFive.rate}</div>
						</div>
						<br><h5>${topFive.rate}</h5>
						<br><h5>${topFive.address}</h5>
						<br><span>${topFive.shortDescription}</span>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>	
	<div class="row align-items-end mt-3">
			<a href="/cafe" class="btn btn-outline-success btn-lg btn-block">Show all cafes</a>			
			<a href="/meal" class="btn btn-outline-info btn-lg btn-block">Show all meals</a>		
	</div>
</div>
<%@ include file="footer.jsp"%>