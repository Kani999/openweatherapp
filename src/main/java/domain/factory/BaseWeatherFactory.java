package domain.factory;

import domain.AWeather;

public abstract class BaseWeatherFactory {
	public abstract AWeather createWeather(String type, String city_name);
}
