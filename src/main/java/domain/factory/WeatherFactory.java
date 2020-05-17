package domain.factory;

import java.util.Date;

import domain.AWeather;
import domain.Weather;
import domain.WeatherOWM;

public class WeatherFactory extends BaseWeatherFactory {

	@Override
	public AWeather createWeather(String type, String city_name) {
		AWeather weather;

		switch (type.toLowerCase()) {
		case "owm":
			weather = new WeatherOWM();
			break;
		case "base":
			weather = new Weather();
			break;
		default:
			weather = new Weather();
		}

		// Set when the instance was updated for determining cache deletion
		weather.setUpdated_at(new Date());
		// Initialize by city_name
		weather.GetTemperatureByCity(city_name);

		return weather;
	}

}
