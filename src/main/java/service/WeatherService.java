package service;

import org.springframework.stereotype.Service;

import domain.Weather;
import domain.WeatherOWM;

@Service
public class WeatherService {

	private WeatherOWM weather;

	public WeatherOWM getWeatherByCity(String city_name) {
		weather = new WeatherOWM();
		weather.GetWeatherByCity(city_name);

		return weather;
	}

}