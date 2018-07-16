package my.weather.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.weather.portal.service.WeatherInfoService;

/**
 *
 * @author agassi.d.h.agapito
 *
 */
@RequestMapping("/api")
@RestController
public class WeatherInfoController {

	@Autowired private WeatherInfoService weatherInfoService;

	@GetMapping(value = "/weather-info/target-cities", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getWeatherOfTargetCities() {
		return weatherInfoService.getWeatherOfTargetCities();
	}
}
