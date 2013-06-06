<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Liste des geeks</title>
<link href="/geektic/css/bootstrap.css" rel="stylesheet">
<link href="/geektic/css/bootstrap-responsive.css" rel="stylesheet"
	media="screen">
<style type="text/css">
body {
	padding-top: 50px;
	padding-bottom: 40px;
}

.girl a:link {
	color: #FFB6C1;
} /* unvisited link */
.girl a:visited {
	color: #FFB6C1;
} /* visited link */
.girl a:hover {
	color: #FFB6C1;
} /* mouse over link */
.girl a:active {
	color: #FFB6C1;
} /* selected link */

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
				<a class="brand" href="#">Geektic</a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<c:if test="${empty interet}">
							<li class="active"><a href="#">Home</a></li>
							<li><a href="./search">Recherche</a></li>
						</c:if>
						<c:if test="${not empty interet}">
							<li><a href="./geeks">Home</a></li>
							<li class="active"><a href="#">Recherche</a></li>
						</c:if>
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
				<li class="nav-header">Geeks <c:if test="${not empty interet}">
				    fans de ${interet}
				</c:if>
				</li>
				<c:forEach items="${listeGeeks}" var="geek">
					<c:if test="${geek.genre == 'Féminin'}">
						<li class="girl"><a href="./geeks/${geek.id}">${geek.nom}
								- ${geek.prenom}</a></li>
					</c:if>
					<c:if test="${geek.genre == 'Masculin'}">
						<li><a href="./geeks/${geek.id}">${geek.nom}
								- ${geek.prenom}</a></li>
					</c:if>
				</c:forEach>
			</ul>
			<c:if test="${not empty interet}">
				<a href="./search"> <br />
					<button type="submit" class="btn btn-primary">Faire une
						nouvelle recherche</button>
				</a>
			</c:if>
		</div>
		<!--/.well -->
	</div>
	<!--/span-->



</body>
</html>