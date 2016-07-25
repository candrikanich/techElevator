<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>
<html>
	<head>
		<title><c:out value="${param.pageTitle}" /> | National Park Geek</title>
		<c:url var="cssHref" value="styles.css" />
		<link type="css/txt" rel="stylesheet" href="${cssHref}" />
		<link href="https://fonts.googleapis.com/css?family=Assistant|Exo:900" rel="stylesheet">
	</head>
	<body>
		<section id="page">
			
			<header>
				<c:url var="homePageUrl" value="parkListing" />
				<a href="${homePageUrl}" title="National Park Geek: Home">
					<c:url var="logoSrc" value="img/NPSlogo.png" />
					<img src="${logoSrc}" alt="National Park Geek Logo" />
				</a>
				<h1>National Park Geek</h1>
				<p>Where Geeks Go To Unplug</p>
			</header>
			<nav>
				<ul>
					<li>
						<c:url var="homePageUrl" value="parkListing" />
						<a href="${homePageUrl}" title="">All Parks</a>
					</li>
					<li>
						<c:url var="dailySurveyUrl" value="dailySurveyInput" />
						<a href="${dailySurveyUrl}" title="##">Daily Survey</a>
					</li>
				</ul>
			</nav>