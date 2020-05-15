package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.Weather;

@Controller
public class WeatherController {
	@RequestMapping("/weather")
	@ResponseBody
	public String weather() {
		// Print weather city - test
		Weather weather = new Weather();
		return weather.getCity();
	}
}
