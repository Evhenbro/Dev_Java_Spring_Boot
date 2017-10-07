<%@ include file="header.jsp"%>
	<div class="container">
	<br>	
	<div class="rounded border border-info">
		<div class="row m-3">
			<div class="col text-center">
				<img src="/resources/cafe.jpg" >
			</div>
			<div class="col">
				<h2>${cafeById.name}</h2>
				<p></p>
				<h4>Type: ${cafeById.type}</h4>
				<h4>Rate:</h4>
				<div class="progress" style="width: 80%">
					<div class="progress-bar bg-success" role="progressbar" style="width: ${cafeById.rate*10}%" aria-valuenow="${cafeById.rate}" aria-valuemin="0" aria-valuemax="10">${cafeById.rate}</div>
				</div>
				<br><h4 class="text-dark font-italic"><i class="fa fa-map-marker" aria-hidden="true"></i> Address: ${cafeById.address}</h4>
				<h5>Phone: ${cafeById.phone}</h5>
				<h5>e-mail: ${cafeById.email}</h5>
				<h5>Open - close time:</h5>
				<h5><strong>${cafeById.open} - ${cafeById.close}</strong></h5>
				<p class="text-center"><a href="/cafe/${cafeById.id}/tables" class="btn btn-warning ">To order a table</a></p>
			</div>
		</div>
		<div class="col row m-3">
			<br><br><span class="font-italic">${cafeById.fullDescription}</span>
		</div>
	</div>
		
		<div>
			<p class="mt-2">
				<a  data-toggle="collapse" href="#collapseExample" aria-expanded="false" aria-controls="collapseExample"><i class="fa fa-pencil" aria-hidden="true"></i>Add comment</a> 
			</p>
			<div class="collapse" id="collapseExample">
				<div class="card card-body">
					<form:form action="/cafe/${cafeById.id}" method="POST" modelAttribute="comment">
						<div class="mt-3">
							<div class="row" style="color: red;">
								<div class="col-10 ml-auto">
									<form:errors path="user"/>
								</div>
							</div>
							<div class="form-group row">
								<label class="col-2 col-form-label" for="user">User:</label>
								<div class="col-10">
									<form:input class="form-control" id="user" path="user"/>
								</div>
							</div>
							<div class="row" style="color: red;">
								<div class="col-10 ml-auto">
									<form:errors path="rate"/>
								</div>
							</div>
							<div class="form-group row">
								<label class="col-2 col-form-label" for="rate">Rate:</label>
								<div class="col-10">
									<form:input class="form-control" id="rate" path="rate"/>
								</div>
							</div>
							<div class="form-group row">
								<label class="col-2 col-form-label" for="message">Message:</label>
								<div class="col-10">
									<form:textarea class="form-control" id="message" path="message" rows="4"/>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-10 ml-auto">
									<button class="btn btn-sm btn-outline-success">Save</button>
									<a href="/cafe/${cafeById.id}/cancel" class="btn btn-sm btn-outline-info">Cancel</a>
								</div>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
		<c:forEach var="comment" items="${comments}">
		<c:set var="comments" value="${comment.childComment}" scope="request"/>
			<div class="row mt-2">
				<div class="col pl-0">
					<span class="text-primary font-weight-bold font-italic"><i class="fa fa-user-circle" aria-hidden="true"></i> ${comment.user}</span>
					<span class="text-dark small font-italic ml-3"><i class="fa fa-clock-o" aria-hidden="true"></i> ${comment.time}</span>
					<span class="ml-3"><i class="fa fa-area-chart" aria-hidden="true"></i> Rate: ${comment.rate}</span>
					<a class="text-dark ml-3" data-toggle="collapse" href="#collapseExample${comment.id}" aria-expanded="false" aria-controls="collapseExample${comment.id}"><i class="fa fa-pencil" aria-hidden="true"></i> <u>to comment</u></a>
					<div>${comment.message}</div>
					<div class="mt-2 mb-2 collapse" id="collapseExample${comment.id}">
						<div class="card card-body">
							<form:form action="/cafe/${cafeById.id}/${comment.id}" method="POST" modelAttribute="commentToComment">
								<div class="row" style="color: red;">
									<div class="col-10 ml-auto">
										<form:errors path="user"/>
									</div>
								</div>
								<div class="form-group row">
									<label class="col-2 col-form-label" for="user">User:</label>
									<div class="col-10">
										<form:input class="form-control" id="user" path="user"/>
									</div>
								</div>
								<div class="form-group row">
									<label class="col-2 col-form-label" for="message">Message:</label>
									<div class="col-10">
										<form:textarea class="form-control" id="message" path="message" rows="4"/>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-10 ml-auto">
										<button class="btn btn-sm btn-outline-success">Save</button>
										<a href="/cafe/${cafeById.id}/cancel" class="btn btn-sm btn-outline-info">Cancel</a>
									</div>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
			<div class="mr-3">
	 			<jsp:include page="comments.jsp"/>
			</div>
		</c:forEach>
	</div>
<%@ include file="footer.jsp"%>