<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Liste des spectacles</title>
<link href="/geektic/css/bootstrap.css" rel="stylesheet">
<link href="/geektic/css/bootstrap-responsive.css" rel="stylesheet"
	media="screen">
<style type="text/css">
body {
	padding-top: 50px;
	padding-bottom: 40px;
}
/* Custom container */
.container-narrow {
	margin: 0 auto;
	max-width: 700px;
}

.container-narrow>hr {
	margin: 30px 0;
}
</style>
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<button type="button" class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="brand" href="#">Geeks</a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li class="active"><a href="#">Home</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>
	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<div class="container-narrow">
		<h1>Liste des geeks</h1>
		<div class="well sidebar-nav">
			<ul>
				<li class="nav-header">Geeks</li>
				<c:forEach items="${listeGeeks}" var="geek">
					<li><a href="./geeks/${geek.id}">${geek.nom} - ${geek.prenom}</a></li>
				</c:forEach>
			</ul>
		</div>
		<!--/.well -->
	</div>
	<!--/span-->



</body>
</html>