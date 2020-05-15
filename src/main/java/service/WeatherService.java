package service;

import org.springframework.stereotype.Service;

import domain.Weather;

@Service
public class WeatherService {

	private Weather weather;

	public Weather getWeatherByCity(String city_name) {
		weather = new Weather();
		weather.GetWeatherByCity(city_name);

		return weather;
	}

}