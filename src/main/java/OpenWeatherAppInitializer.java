import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "controller", "service", "config" })
@SpringBootApplication
@EnableCaching
public class OpenWeatherAppInitializer extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(OpenWeatherAppInitializer.class, args);
	}
}