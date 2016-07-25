<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="header.jsp">
    <c:param name="pageTitle" value="Daily Survey" />
</c:import>

<section id="addSurvey">
	<c:choose>
	    <c:when test="${survey == null}">
		 	<h2>Which park is your favorite</h2>
		 	<p>Click on image to choose your favorite</p>
			<c:forEach items="${parks}" var="theParks">
				<form action="addSurvey" method="POST">
					<button type="submit" name="parkCode" value="${theParks.parkCode}">
						<img src="img/parks/${theParks.parkCode}.jpg" alt="${theParks.name}" />
						<p>${theParks.name}</p>
		 			</button>	
				</form>
			</c:forEach>
	     </c:when>
	    <c:otherwise>
	    
		 	<h2>Survey Results:</h2>
		 	
		 	<table>
				
			<c:forEach items="${parks}" var="theParks">
				<tr>
				<td>${theParks.name}:</td>		
					
				<c:choose>
					<c:when test="${allSurveys[theParks.parkCode] != null}">
  						<td>
  							<c:forEach begin="1" end="${allSurveys[theParks.parkCode]}">
  								<div class="surveyNum ${theParks.parkCode}">&nbsp;</div>
  							</c:forEach>
  							<c:out value="${allSurveys[theParks.parkCode]}" />
  						</td>
  					</c:when>
  					<c:otherwise>
  						<td>This park gets no love</td>
  					</c:otherwise>
  				</c:choose>
  				</tr>
 			</c:forEach>
				</table>
 	    </c:otherwise>
	</c:choose>	
</section>
<c:import url="footer.jsp" />
