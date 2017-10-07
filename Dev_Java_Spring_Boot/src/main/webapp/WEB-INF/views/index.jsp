<%@ include file="header.jsp"%>
<div class="container">
	<h2 class="text-center">${message}</h2>
	<div  class="mx-auto text-center mt-2">
		<h2 class="text-success">TOP 5 CAFES</h2>
	</div>
	
	<div id="carouselExampleIndicators" class="carousel slide  text-primary" data-ride="carousel">
	 	<ol class="carousel-indicators">
		    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
		    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
		    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		    <li data-target="#carouselExampleIndicators" data-slide-to="4"></li>
		    <li data-target="#carouselExampleIndicators" data-slide-to="5"></li>
	  	</ol>
	 	<div class="carousel-inner" >
		    <div class="carousel-item active">
		   		<img class="d-block w-100" src="/resources/grey.jpg" alt="First slide">
		   		<div class="carousel-caption d-none d-md-block" >
		   			<img class="d-block" src="/resources/cafe.jpg" width="750">
			    	<h3 class=" text-primary"><a href="/cafe/${top5.id}">${top5.name}</a></h3>
			    	<h5 class="text-dark font-italic"><i class="fa fa-map-marker" aria-hidden="true"></i> ${top5.address}</h5>
			    	<p class="text-dark">${top5.shortDescription}</p>
				</div>
		    </div>
		    <div class="carousel-item">
		   		<img class="d-block w-100" src="/resources/grey.jpg" alt="First slide">
		   		<div class="carousel-caption d-none d-md-block">
		   			<img class="d-block" src="/resources/cafe.jpg" width="750">
			    	<h3 class=" text-primary"><a href="/cafe/${top4.id}">${top4.name}</a></h3>
			    	<h5 class="text-dark font-italic"><i class="fa fa-map-marker" aria-hidden="true"></i> ${top4.address}</h5>
			    	<p class="text-dark">${top4.shortDescription}</p>
				</div>
		    </div>
		    <div class="carousel-item">
		   		<img class="d-block w-100" src="/resources/grey.jpg" alt="First slide">
		   		<div class="carousel-caption d-none d-md-block">
		   			<img class="d-block" src="/resources/cafe.jpg" width="750">
			    	<h3 class=" text-primary"><a href="/cafe/${top3.id}">${top3.name}</a></h3>
			    	<h5 class="text-dark font-italic"><i class="fa fa-map-marker" aria-hidden="true"></i> ${top3.address}</h5>
			    	<p class="text-dark">${top3.shortDescription}</p>
				</div>
		    </div>
		    <div class="carousel-item">
		    	<img class="d-block w-100" src="/resources/grey.jpg" alt="Second slide">
		    	<div class="carousel-caption d-none d-md-block">
		    		<img class="d-block" src="/resources/cafe.jpg" width="750">
			    	<h3 class=" text-primary"><a href="/cafe/${top2.id}">${top2.name}</a></h3>
			    	<h5 class="text-dark font-italic"><i class="fa fa-map-marker" aria-hidden="true"></i> ${top2.address}</h5>
			    	<p class="text-dark">${top2.shortDescription}</p>
				</div>
		    </div>
		    <div class="carousel-item">
		   		<img class="d-block w-100" src="/resources/grey.jpg" alt="Third slide">
		   		<div class="carousel-caption d-none d-md-block">
		   			<img class="d-block" src="/resources/cafe.jpg" width="750">
			    	<h3 class=" text-primary"><a href="/cafe/${top1.id}">${top1.name}</a></h3>
			    	<h5 class="text-dark font-italic"><i class="fa fa-map-marker" aria-hidden="true"></i> ${top1.address}</h5>
			    	<p class="text-dark">${top1.shortDescription}</p>
				</div>
		    </div>
	  	</div>
	  	<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
		    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    <span class="sr-only">Previous</span>
	  	</a>
	  	<a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="sr-only">Next</span>
	  	</a>
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