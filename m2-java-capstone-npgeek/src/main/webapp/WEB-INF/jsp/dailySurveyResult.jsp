<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="header.jsp">
    <c:param name="pageTitle" value="Daily Survey Results" />
</c:import>

<!-- Where's the beef? -->

<table>

	<!-- for each park in the park file, create a table row -->
	<c:forEach items="${parks} var="theParks">
	<tr>
		<td>${theParks.name}</td>
		<td>** survey results **</td>
		<!-- for each line in the survey file, if the survey code == park code for this line, then add <div>&nbsp;</div>  -->
	</tr>
	</c:forEach>

</table>

<c:import url="footer.jsp" />