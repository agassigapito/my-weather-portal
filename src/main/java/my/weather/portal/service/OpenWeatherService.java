package my.weather.portal.service;

import static my.weather.portal.constants.Constants.APPID;
import static my.weather.portal.constants.Constants.ENTRY_METHOD;
import static my.weather.portal.constants.Constants.EXIT_METHOD;
import static my.weather.portal.constants.Constants.PARAM_Q;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.HtmlUtils;
import org.springframework.web.util.UriComponentsBuilder;

import my.weather.portal.config.UrlConfig;
import my.weather.portal.model.WeatherInfoWrapper;

/**
 *
 * @author agassi.d.h.agapito
 *
 */
@Service
public class OpenWeatherService {

	private static final Logger log = LoggerFactory.getLogger(OpenWeatherService.class);

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private UrlConfig urlConfig;

	/**
	 * This method gets the weather city by name through OpenWeatherMap's get Weather by city name.
	 * Endpoint: http://api.openweathermap.org/data/2.5/weather?q={city name}
	 *
	 * @param city
	 * @return WeatherInfoWrapper
	 */
	public WeatherInfoWrapper getWeatherInfoByCity(String city) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		log.debug(ENTRY_METHOD + methodName);

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(urlConfig.getWeatherAppEndpoint())
				.queryParam(PARAM_Q, HtmlUtils.htmlUnescape(city)).queryParam(APPID, urlConfig.getWeatherAppId());
		log.debug("URL: " + builder.buildAndExpand().toUri());
		log.debug(EXIT_METHOD + methodName);
		return restTemplate.getForEntity(builder.buildAndExpand().toUri(), WeatherInfoWrapper.class).getBody();
	}

}
