package domain;

import java.util.Date;

public class Weather {

	protected String city;
	protected Double temperature;
	protected Integer dt;
	protected Date updated_at;

	// Test constructor
	public Weather() {
		this.city = "Opava";
		this.temperature = 45.0;
	}

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

}