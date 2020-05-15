package domain;

import net.aksingh.owmjapis.*;
import net.aksingh.owmjapis.OpenWeatherMap;

import java.io.IOException;

import org.json.JSONException;

import config.OwmApiConfig;

public class WeatherOWM extends AWeather {
	private int cityID;
	private String description;
	private Double temperature;
	private String pressure;
	private String humidity;
	private float wind;
	private String iconID;

	public int getCityID() {
		return cityID;
	}

	public void setCityID(int cityID) {
		this.cityID = cityID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public String getPressure() {
		return pressure;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public float getWind() {
		return wind;
	}

	public void setWind(float wind) {
		this.wind = wind;
	}

	public String getIconID() {
		return iconID;
	}

	public void setIconID(String iconID) {
		this.iconID = iconID;
	}

	// Constructor - initialize by city_name
	public WeatherOWM(String city_name) throws JSONException, IOException {
		this.city = city_name;
		GetTemperatureByCity(city_name);
	}

	@Override
	public void GetTemperatureByCity(String city_name) {
		// use openweathermap java api lib
		final String appid = OwmApiConfig.getApiKey();
		OpenWeatherMap wm = new OpenWeatherMap(appid);
		CurrentWeather cw = null;
		try {
			cw = wm.currentWeatherByCityName(city_name);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.description = cw.getWeatherInstance(0).getWeatherDescription();
		this.pressure = String.valueOf(cw.getMainInstance().getPressure());
		this.humidity = String.valueOf(cw.getMainInstance().getHumidity());
		this.wind = cw.getWindInstance().getWindSpeed();
		this.iconID = cw.getWeatherInstance(0).getWeatherIconName();

		// abstract class variables
		this.city = city_name;
		this.temperature = (double) cw.getMainInstance().getTemperature();
		// this.dt = cwd.getDateTime();
	}
}