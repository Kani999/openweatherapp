package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WeatherController {
	@RequestMapping("/weather")
	@ResponseBody
	public String weather() {
		return "What a sunny day.";
	}
}
