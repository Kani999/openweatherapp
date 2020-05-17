package service;

import java.io.IOException;

import org.json.JSONException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import domain.AWeather;
import domain.factory.BaseWeatherFactory;
import domain.factory.WeatherFactory;

@Service
public class WeatherService {
	private BaseWeatherFactory weatherFactory = new WeatherFactory();

	@Cacheable(value="weather", key="#city_name")
	public AWeather getWeatherByCity(String city_name) throws JSONException, IOException {

		// Print line to console when cache is not used
		System.out.println("CACHE MISS for city " + city_name );

		return weatherFactory.createWeather("owm", city_name);
	}
}