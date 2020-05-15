package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.Weather;
import service.WeatherService;

@Controller
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	@RequestMapping("/weather")
	@ResponseBody
	public String weather() {
		// Print weather city - test
		Weather weather = weatherService.getWeather();
		return weather.getCity();
	}
}
