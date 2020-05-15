package domain;

import java.io.IOException;
import java.util.Date;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Weather {

	protected String city;
	protected Double temperature;
	protected Integer dt;
	protected Date updated_at;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date update_at) {
		this.updated_at = update_at;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Integer getDt() {
		return dt;
	}

	public void setDt(Integer dt) {
		this.dt = dt;
	}

	// Call OpenWeatherMap API and init values
	public void GetWeatherByCity(String city_name) {
		final String appid = "*************API KEY*****************";

		// Create API URI path
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