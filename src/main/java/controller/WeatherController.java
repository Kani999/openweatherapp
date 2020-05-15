package controller;

import java.io.IOException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.AWeather;
import service.WeatherService;

@Controller
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	@RequestMapping("/weather/city")
	public void weather(Model model) throws JSONException, IOException {
		AWeather weather = weatherService.getWeatherByCity("Opava");
		model.addAttribute("weather", weather);
	}
}
