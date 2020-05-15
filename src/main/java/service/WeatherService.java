package service;

import org.springframework.stereotype.Service;

import domain.Weather;

@Service
public class WeatherService {

	private Weather weather;

	public Weather getWeather() {
		weather = new Weather();

		return weather;
	}

}