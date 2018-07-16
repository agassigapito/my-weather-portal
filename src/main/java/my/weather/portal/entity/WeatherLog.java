package my.weather.portal.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.LastModifiedDate;

/**
 *
 * @author agassi.d.h.agapito
 *
 */
@Entity
@Table(name = "WEATHER_LOG")
public class WeatherLog implements Serializable {

	private static final long serialVersionUID = 4686005322915784925L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private long weatherLogId;

	@NotNull
	private String responseId;

	@NotNull
	private String location;

	@NotNull
	private String actualWeather;

	@NotNull
	private String temperature;

	@LastModifiedDate
	@NotNull
	private Timestamp dtimeInserted = new Timestamp(new Date().getTime());

	public long getWeatherLogId() {
		return weatherLogId;
	}

	public void setWeatherLogId(long weatherLogId) {
		this.weatherLogId = weatherLogId;
	}

	public String getResponseId() {
		return responseId;
	}

	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}

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

	public Timestamp getDtimeInserted() {
		return dtimeInserted;
	}

	public void setDtimeInserted(Timestamp dtimeInserted) {
		this.dtimeInserted = dtimeInserted;
	}

}
