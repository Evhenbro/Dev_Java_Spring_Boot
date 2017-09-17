<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
		<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
		<title>ReSt_FoOd</title>
	</head>
	<body>
		<header>
			<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd;">
				<a class="navbar-brand" href="/">ReSt_FoOd</a>
			  		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
						<i class="fa fa-bars" aria-hidden="true"></i>
					</button>
			
			  		<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
			    		<div class="navbar-nav">
					     	<a class="nav-item nav-link" href="/"><i class="fa fa-home" aria-hidden="true"></i> Home</a>
					     	<a class="nav-item nav-link" href="/cafe"><i class="fa fa-user-circle-o" aria-hidden="true"></i> Client</a>
					     	<a class="nav-item nav-link" href="/administrator"><i class="fa fa-cube" aria-hidden="true"></i> Administrator</a>
					      	<sec:authorize access="hasRole('ROLE_ADMIN')">
					      		<a class="nav-item nav-link" href="/admin"><i class="fa fa-user-secret" aria-hidden="true"></i> Admin</a>
					      	</sec:authorize>
					    </div>
			    		<div class="navbar-nav ml-auto">
			    			<a class="nav-item nav-link" href="/login"><i class="fa fa-sign-in" aria-hidden="true"></i> Sign in</a>
			    			<!-- data-toggle="modal" data-target="#loginInSystem" -->
			    			<%-- <%@ include file="modal.jsp"%> --%>
			    			<a class="nav-item nav-link" href="/registration">Sign up</a>
					      	<a class="nav-item nav-link" href="/search"><i class="fa fa-search" aria-hidden="true"></i></a>
			    		</div>
			  </div>
			</nav>
		</header>