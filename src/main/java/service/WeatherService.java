package service;

import java.io.IOException;

import org.json.JSONException;
import org.springframework.stereotype.Service;

import domain.AWeather;
import domain.factory.BaseWeatherFactory;
import domain.factory.WeatherFactory;

@Service
public class WeatherService {
	private BaseWeatherFactory weatherFactory = new WeatherFactory();

	public AWeather getWeatherByCity(String city_name) throws JSONException, IOException {
		AWeather weather = weatherFactory.createWeather("owm", city_name);

		return weather;
	}
}