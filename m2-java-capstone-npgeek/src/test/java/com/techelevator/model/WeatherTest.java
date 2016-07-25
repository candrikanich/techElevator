package com.techelevator.model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class WeatherTest {

	@Test
	public void testPopulationofAdvice() {
		
		Weather weather = new Weather("GTNP",	1,	27,	80,	"cloudy", true);
		
		List<String> advice = weather.getAdvice();
		assertEquals(2, advice.size());
	}
	
	@Test
	public void testAdviceForRain() {
		
		Weather weather = new Weather("GTNP",	1,	27,	66,	"rain", true);
		
		List<String> advice = weather.getAdvice();
		assertEquals("Pack Rain Gear and waterproof shoes", advice.get(0));
	}
	
	@Test
	public void testAdviceForSunny() {
		
		Weather weather = new Weather("GTNP",	1,	27,	66,	"sunny", true);
		
		List<String> advice = weather.getAdvice();
		assertEquals("Pack Sunblock to avoid harmful sun rays", advice.get(0));
	}
	
	@Test
	public void testAdviceForSnow() {
		
		Weather weather = new Weather("GTNP",	1,	27,	66,	"snow", true);
		
		List<String> advice = weather.getAdvice();
		assertEquals("Pack snowshoes", advice.get(0));
	}
	
	@Test
	public void testAdviceForThunderstorms() {
		
		Weather weather = new Weather("GTNP",	1,	27,	66,	"thunderstorms", true);
		
		List<String> advice = weather.getAdvice();
		assertEquals("Seek shelter and avoid hiking on exposed ridges or mountaintops", advice.get(0));
	}
	
	@Test
	public void testAdviceForTempLessThan20() {
		
		Weather weather = new Weather("GTNP",	1,	12,	66,	"rain", true);
		
		List<String> advice = weather.getAdvice();
		assertEquals("Frostbite warning in effect today", advice.get(1));
	}
	
	@Test
	public void testAdviceForTempDifferenceGT20() {
		
		Weather weather = new Weather("GTNP",	1,	12,	66,	"rain", true);
		
		List<String> advice = weather.getAdvice();
		assertEquals("Wear breathable layers", advice.get(2));
	}
	

	@Test
	public void testConversiontoCelcius() {
		
		Weather weather = new Weather("GTNP",	1,	32,	100,	"cloudy", true);
		
		assertEquals(0, weather.getLowTemp());
		assertEquals(37, weather.getHighTemp());
	}

	@Test
	public void testNoConversionOfTemp() {
		
		Weather weather = new Weather("GTNP",	1,	32,	100,	"cloudy", false);
		
		assertEquals(32, weather.getLowTemp());
		assertEquals(100, weather.getHighTemp());
	}


}
