package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.Weather;
import service.WeatherService;

@Controller
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	@RequestMapping("/weather/city")
	public void weather(Model model) {
		// Print weather city - test
		Weather weather = weatherService.getWeather();
		model.addAttribute("weather", weather);
	}
}
