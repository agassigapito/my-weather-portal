package my.weather.portal.service;

import static my.weather.portal.constants.Constants.ENTRY_METHOD;
import static my.weather.portal.constants.Constants.EXIT_METHOD;

import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.weather.portal.entity.WeatherLog;
import my.weather.portal.model.WeatherInfoWrapper;
import my.weather.portal.repository.WeatherLogRepository;

/**
 *
 * @author agassi.d.h.agapito
 *
 */
@Service
public class WeatherLogService {

	@Autowired
	private WeatherLogRepository weatherLogRepository;

	private static final Logger log = LoggerFactory.getLogger(WeatherLogService.class);

	/**
	 * This method creates a log into the Database of the weather information per location.
	 *
	 * @param weatherInfoWrapper
	 */
	public void createWeatherLog(WeatherInfoWrapper weatherInfoWrapper) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		log.debug(ENTRY_METHOD + methodName);

		WeatherLog weatherLog = new WeatherLog();
		weatherLog.setActualWeather(weatherInfoWrapper.getWeathers()
				.stream()
				.map(weather -> weather.getDescription())
				.limit(5)
	            .collect(Collectors.joining(" with ")));
		weatherLog.setLocation(weatherInfoWrapper.getLocationName());
		weatherLog.setResponseId(UUID.randomUUID().toString());
		weatherLog.setTemperature(weatherInfoWrapper.getMainInfo().getTemp().toPlainString());

		weatherLogRepository.saveAndFlush(weatherLog);

		log.debug(EXIT_METHOD + methodName);
	}
}
