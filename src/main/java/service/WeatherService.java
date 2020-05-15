package service;

import java.io.IOException;

import org.json.JSONException;
import org.springframework.stereotype.Service;

import domain.AWeather;
import domain.Weather;
import domain.WeatherOWM;

@Service
public class WeatherService {

	// TODO: Determine which class (Weather, WeatherOWM) to use. Factory?

	private AWeather weather;

	public AWeather getWeatherByCity(String city_name) throws JSONException, IOException {
		weather = new WeatherOWM(city_name);
		// weather = new Weather(city_name);

		return weather;
	}
}