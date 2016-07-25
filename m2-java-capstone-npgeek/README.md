# Module 2 Capstone - National Park Geek


You have been asked to develop a web application for the National Park Service. The application is able to display some overview information about our U.S. National Parks and provide a daily weather forecast.

## Requirements

The requirements for your application are listed below:

1. The site that you develop will need to have a consistent look and feel across all pages. It should be a visually appealing layout. 

2. The home page should display a list of the national parks. This page should contain a short summarization about each park including a picture, park name, and its location.

3. Every national park has its own page in which further details are provided. Each park page should follow a consistent layout and the details should include information made available from the Park Data Source.

4. Every national park should have a 5-day weather forecast. The forecast for each park can be obtained from the Weather Forecast Data Source.

5. Along with the forecast, the weather page should display advice to the user that recommends how they prepare for the weather based on the day’s forecast. For example:
    1. If it is snowing, tell the user to make sure that they include snowshoes.

    2. If it is raining, tell the user to pack rain gear and wear waterproof shoes.

    3. If it is thunderstorming, tell the user to seek shelter and avoid hiking on exposed ridges or mountaintops.

    4. If it is sunny, tell the user to pack sunblock to avoid harmful sun rays.

    5. If the temperature is going to exceed 75 degrees, then tell the user to bring an extra gallon of water with them.

    6. If the difference between the high and low temperature exceeds 20 degrees, tell the user to wear breathable layers.

    7. If the temperature drops below 20 degrees, make sure that the user is warned of the dangers of exposure to frigid temperatures and that they may cause frostbite.

6. The weather forecast page should allow the user to display temperatures in Celsius or Fahrenheit. Once the user changes the default setting, the site should remember that choice on any subsequent weather forecast pages.

7. There is a daily survey component to the site. If the user has not yet taken a survey, they are prompted to click on a link and take the survey of the day.
    1. When a user clicks the survey link, if the user has not taken the survey previously, the survey input is displayed so that they can take the survey.  If the user has previously taken the survey, the survey results are shown instead.

    2. Today’s survey will ask the user to vote on their favorite national park. Results should be permanently saved so that all users who complete the survey can see the park rankings.

8. Its hard to tell what the future will bring, so providing thorough unit testing of the components is critical.

## Data Sources

Your application will have access to the following sources of data:

### Daily Weather File

A daily weather file is provided to the system that provides weather forecast data for the next 5 days.  This file is tab-delimited.  This means that each record in the file ends with a “newline” character and each field is separated by a “tab” character.  The data columns are as follows:

| Field | Description|
|-------|------------|
| Park Code | A short String that uniquely identifies a park. (see below for list of park codes) |
| Day | The forecast day.  Today is day 1, tomorrow is day 2, etc. |
| Low | The expected low temperature in degrees Fahrenheit |
| High | The expected high temperature in degrees Fahrenheit |
| Forecast | The expected weather. Possible values are: sunny, partly cloudy, cloudy, rain, thunderstorms, snow |

### Park Data File
A park data file that contains information about each park.  This file is tab-delimited.  This means that each record in the file ends with a “newline” character and each field is separated by a “tab” character.  The data columns are as follows:

| Field | Description |
|-------|-------------|
| Park Code | A short String that uniquely identifies a park. (see below for list of park codes) |
| Park Name | The name of the park (e.g. “Grand Canyon National Park) |
| State | The state in which the park is located |
| Acreage | The size of the park in acres |
| Elevation in Feet | The park’s elevation above sea level (in feet) |
| Miles of Trail | The combined length of all hiking trails in the park |
| Number of Campsites | The total number of campsites available for visitors in the park |
| Climate | A generate description of the park’s climate (e.g. “Desert”) |
| Year Founded | The year the park joined the National Park System |
| Annual Visitor Count | The average number of visitors to the park on an annual basis |
| Quote | A famous quote related to the park |
| Quote Source | The person to whom the quote is attributed |
| Description | A description of the park |
| Entry Fee | The cost to enter the park in dollars. Starts with a dollar sign. (e.g. $10) |
| Number of Animal Species | The number of different animal species that can be found within the boundaries of the park |

### Park Code Values

| Park Code | Park |
|-----------|------|
| GNP | Glacier National PArk |
| GCNP | Grand Canyon NAtional Park |
| GTNP | Grand Teton National Park |
| MRNP | Mount Rainier National Park |
| GSMNP | Great Smoky Mountain National Park |
| ENP | Everglades National Park |
| YNP | Yellowstone National Park |
| YNP2 | Yosemite National Park |
| CVNP | Cuyahoga Valley National Park |
| RMNP | Rocky Mountain National Park |
