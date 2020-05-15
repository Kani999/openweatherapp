package domain;

import java.io.IOException;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import config.OwmApiConfig;

public class Weather extends AWeather {
	// Constructor - initialize variables by city_name
	public Weather(String city_name) {
		this.city = city_name;
		GetTemperatureByCity(city);
	}

	@Override
	public void GetTemperatureByCity(String city_name) {
		final String appid = OwmApiConfig.getApiKey();

		// Build openweathermap Uri path
		UriComponentsBuilder uriComponents = UriComponentsBuilder.newInstance().scheme("http")
				.host("api.openweathermap.org").path("data/2.5/weather").queryParam("q", city_name)
				.queryParam("appid", appid);

		final String uri = uriComponents.buildAndExpand().toUri().toString();

		// get result from api
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);

		// map result to JsonNode
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = null;
		
		try {
			jsonNode = objectMapper.readTree(result);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// initialize object
		this.setCity(jsonNode.get("name").toString());
		this.setTemperature(jsonNode.get("main").get("temp").asDouble());
		// weather.setUpdate_at(update_at);
	}
}