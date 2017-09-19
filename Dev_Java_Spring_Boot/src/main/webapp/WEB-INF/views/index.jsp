<%@ include file="header.jsp"%>
<div class="container">
	<h2 class="text-center">${message}</h2>
	<div  class="mx-auto text-center mt-2">
		<h2 class="text-success">TOP 5 CAFES</h2>
	</div>
	<div class="row mt-3">
		<div class="col-12 bg-danger" ></div>
	</div>	
	<div class="row align-items-end mt-3">
			<a href="/cafe" class="btn btn-outline-success btn-lg btn-block">Show all cafes</a>			
			<a href="/meal" class="btn btn-outline-info btn-lg btn-block">Show all meals</a>		
	</div>
</div>
<%@ include file="footer.jsp"%>