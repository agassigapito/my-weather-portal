package my.weather.portal.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author agassi.d.h.agapito
 *
 */
@Configuration
public class UrlConfig {

	@Value("${weather.app.id}")
	private String weatherAppId;

	@Value("${weather.app.endpoint}")
	private String weatherAppEndpoint;

	public String getWeatherAppId() {
		return weatherAppId;
	}

	public void setWeatherAppId(String weatherAppId) {
		this.weatherAppId = weatherAppId;
	}

	public String getWeatherAppEndpoint() {
		return weatherAppEndpoint;
	}

	public void setWeatherAppEndpoint(String weatherAppEndpoint) {
		this.weatherAppEndpoint = weatherAppEndpoint;
	}


}
