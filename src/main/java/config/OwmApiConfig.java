package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class OwmApiConfig {
	public static String OwmApiKey;

	@Value("${my.owmkey}")
	public void setOwmApiKey(String api_key) {
		OwmApiConfig.OwmApiKey = api_key;
	}

	public OwmApiConfig() {
	}

	public static String getApiKey() {
		return OwmApiKey;
	}
}