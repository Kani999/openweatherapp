package controller;

import java.io.IOException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.AWeather;
import service.WeatherService;

@RequestMapping("/weather")
@Controller
public class WeatherController {
	@Autowired
	private WeatherService weatherService;

	@RequestMapping(value = "/{cityName}", method = RequestMethod.GET)
	public String weather(Model model, @PathVariable String cityName) throws JSONException, IOException {
		AWeather weather = weatherService.getWeatherByCity(cityName);
		model.addAttribute("weather", weather);
		return "/weather/city";
	}

}