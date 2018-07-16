package my.weather.portal.dto;

import java.io.Serializable;

/**
 *
 * @author agassi.d.h.agapito
 *
 */
public class WeatherInfoDto implements Serializable {

	private static final long serialVersionUID = 1131326648452219172L;

	private String location;

	private String actualWeather;

	private String temperature;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getActualWeather() {
		return actualWeather;
	}

	public void setActualWeather(String actualWeather) {
		this.actualWeather = actualWeather;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

}
