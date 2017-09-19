<%@ include file="header.jsp"%>
<div class="container">
	<h2 class="text-center">${message}</h2>
	<div  class="mx-auto text-center mt-2">
		<h4 class="text-success">THERE YOU CAN MANAGE YOURSELF CAFE</h4>
	</div>
	<div class="row align-items-end mt-3">
			<a href="/profile/cafe" class="btn btn-outline-success btn-lg btn-block">Show my own cafes</a>			
			<a href="/profile/meal" class="btn btn-outline-info btn-lg btn-block">Show my own meals</a>		
	</div>
</div>
<%@ include file="footer.jsp"%>