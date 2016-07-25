<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="header.jsp">
    <c:param name="pageTitle" value="Park Listings" />
</c:import>

				<section id="parkListing">
					
						<header>
							<h2>List of National Parks</h2>
						</header>
						
						<!-- Display block list of National Parks -->
						<c:forEach items="${parks}" var="theParks">
						<div class="parkListing">
							<c:url var="parkDetailsHref" value="parkDetail" >
								<c:param name="parkCode">${theParks.parkCode}</c:param>
							</c:url>
							<a href="${parkDetailsHref}" title="${theParks.name}">
								<img src="img/parks/${theParks.parkCode}.jpg" alt="${theParks.name}" />
							</a>
		
							<a href="${parkDetailsHref}" title="${theParks.name}">
								<h3>${theParks.name}</h3>
							</a>
							
							<p class="parkLocation">${theParks.state}</p>
							<p class="parkSummary">${theParks.summary} <a href="${parkDetailsHref}" title="Read more about ${theParks.name}">Read&nbsp;More</a></p>
							<%-- <p class="parkSummary">${theParks.description}</p> --%>
						</div>
						</c:forEach>
					
				</section>


<c:import url="footer.jsp" />