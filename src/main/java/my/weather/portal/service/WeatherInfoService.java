package my.weather.portal.service;

import static my.weather.portal.constants.Constants.ENTRY_METHOD;
import static my.weather.portal.constants.Constants.EXIT_METHOD;
import static my.weather.portal.constants.Constants.TARGET_CITIES;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import my.weather.portal.dto.WeatherInfoDto;
import my.weather.portal.model.ResponseStatus;
import my.weather.portal.model.WeatherInfoWrapper;

/**
 *
 * @author agassi.d.h.agapito
 *
 */
@Service
public class WeatherInfoService {

	@Autowired
	private OpenWeatherService openWeatherService;

	@Autowired
	private WeatherLogService weatherLogService;

	private static final Logger log = LoggerFactory.getLogger(WeatherInfoService.class);

	/**
	 * This method gets the weather information for the target cities: London, Prague and San Fransisco.
	 * Then logs it to the database.
	 *
	 * @return ResponseEntity<List<WeatherInfoDto>>
	 */
	public ResponseEntity<?> getWeatherOfTargetCities() {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		log.debug(ENTRY_METHOD + methodName);


		ResponseEntity<?> responseEntity = null;
		List<WeatherInfoDto> weatherInfoDtoList = new ArrayList<WeatherInfoDto>();
		try {
			TARGET_CITIES.stream().forEach(city -> {
				WeatherInfoWrapper weatherInfoWrapper = openWeatherService.getWeatherInfoByCity(city);
				weatherLogService.createWeatherLog(weatherInfoWrapper);

				WeatherInfoDto weatherInfo = new WeatherInfoDto();
				weatherInfo.setActualWeather(weatherInfoWrapper.getWeathers()
						.stream()
						.map(weather -> weather.getDescription())
						.limit(5)
			            .collect(Collectors.joining(" with ")));
				weatherInfo.setLocation(city);
				weatherInfo.setTemperature(weatherInfoWrapper.getMainInfo().getTemp().toPlainString());

				weatherInfoDtoList.add(weatherInfo);
			});
			responseEntity = new ResponseEntity<List<WeatherInfoDto>>(weatherInfoDtoList,
					HttpStatus.OK);
		} catch (HttpClientErrorException | HttpServerErrorException e) {
			log.error(e.getResponseBodyAsString());
			log.error(e.getMessage(), e);
			responseEntity = new ResponseEntity<ResponseStatus>(new ResponseStatus(e.getResponseBodyAsString()),
					HttpStatus.CONFLICT);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			responseEntity = new ResponseEntity<ResponseStatus>(new ResponseStatus(e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			log.debug(EXIT_METHOD + methodName);
		}
		return responseEntity;
	}
}
