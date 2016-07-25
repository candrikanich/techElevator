<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="header.jsp">
    <c:param name="pageTitle" value="Park Detail" />
</c:import>

					<section id="parkDetail">
						
						<header>
							<h2>${park.name}</h2>
							<p class="parkLocation">${park.state}</p>
							<ul>
								<li><span>Founded: </span>${park.yearFounded}</li>
								<li><span>Climate: </span>${park.climate}</li>
								<li><span>Entry Fee: </span>${park.entryFee}</li>
							</ul>
						</header>
						
						<img class="parkImage" src="img/parks/${park.parkCode}.jpg" alt="${park.name}" />
						<blockquote>&ldquo;${park.famousQuote}&rdquo;<br />&mdash; ${park.famousQuoteSource}</blockquote>						
						<h3>About ${park.name}:</h3>
						<p class="parkSummary">${park.description}</p>

						<h3>${park.name} by the Numbers:</h3>						
						<table id="byTheNumbers" cellspacing="0">
							<thead>
								<td>Elevation</td>
								<td>Acreage</td>
								<td>Miles of Trails</td>
								<td>Number of Campsites</td>
								<td>Number of Visitors (Annual)</td>
								<td>Number of Animal Species</td>
							</thead>
							<tr>
								<td class="cellOne">${park.elevation}</td>
								<td class="cellTwo">${park.acreage}</td>
								<td class="cellThree">${park.milesOfTrails}</td>
								<td class="cellFour">${park.numberOfCampsites}</td>
								<td class="cellFive">${park.annualNumberOfVisitors}</td>
								<td class="cellSix">${park.numberOfAnimalSpecies}</td>
							</tr>
							
						</table>
						
				</section>
				
				<section id="todaysWeather">
					<h4>Today's Weather</h4>
					<c:forEach items="${weather}" begin="0" end="0" var="todaysWeather">
					
						<img src="img/weather/${todaysWeather.foreCast}.png" alt="Todays Weather is ${todaysWeather.foreCast}" />
						<h5>${todaysWeather.foreCast}</h5>
						<c:if test="${isCelcius==true}">
							<p>High: ${todaysWeather.highTemp} &deg;C / Low: ${todaysWeather.lowTemp} &deg;C</p>
						</c:if>	
						<c:if test="${isCelcius==false}">
							<p>High: ${todaysWeather.highTemp} &deg;F / Low: ${todaysWeather.lowTemp} &deg;F</p>
						</c:if>	
			
						
					</c:forEach>
					<div id="toCelcius">
							<form action="parkDetail" method="POST">
								<c:if test="${isCelcius==true}">
									<input type="hidden" name="isCelcius" value="false" />
								</c:if>	
								<c:if test="${isCelcius==false}">
									<input type="hidden" name="isCelcius" value="true" />
								</c:if>	
								
								<c:if test="${isCelcius==false}">
									<input type="submit" value="Convert to Celcius" />
								</c:if>
								<c:if test="${isCelcius==true}">
									<input type="submit" value="Convert to Fahrenheit" />
								</c:if>
							</form>
						</div>
				</section>
				
				<section id="weatherTips">
					<h4>Recommended Preparation</h4>
					<c:set var="advice" value="${weather[0].advice}" />
					<c:forEach items="${advice}"  var="weatherTips">
						<p>${weatherTips}</p>
					</c:forEach>
				</section>
	
				<section id="fiveDayForecast">
					<table cellspacing="0">
						<tr>
							<td>Today</td>
							<td>Tomorrow</td>
							<td>Day 3</td>
							<td>Day 4</td>
							<td>Day 5</td>
						</tr>
						<tr>
							<c:forEach items="${weather}" begin="0" end="5" var="fiveDay">
								<td>
									<img src="img/weather/${fiveDay.foreCast}.png" />
									<p class="forecast">${fiveDay.foreCast}</p>
								
									<c:if test="${isCelcius==true}">
										<p>${fiveDay.highTemp} &deg;C / ${fiveDay.lowTemp} &deg;C</p>
									</c:if>	
									<c:if test="${isCelcius==false}">
										<p>${fiveDay.highTemp} &deg;F / ${fiveDay.lowTemp} &deg;F</p>
									</c:if>
									
								</td>
							</c:forEach>
							
						</tr>
					</table>
					
				</section>
				
<c:import url="footer.jsp" />