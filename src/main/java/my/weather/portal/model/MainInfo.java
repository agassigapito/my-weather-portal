package my.weather.portal.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author agassi.d.h.agapito
 *
 */
public class MainInfo implements Serializable {

	private static final long serialVersionUID = -8647586213157840275L;

	private BigDecimal temp;

	private BigDecimal humidity;

	@JsonProperty("temp_min")
	private BigDecimal tempMin;

	@JsonProperty("temp_max")
	private BigDecimal tempMax;

	public BigDecimal getTemp() {
		return temp;
	}

	public void setTemp(BigDecimal temp) {
		this.temp = temp;
	}

	public BigDecimal getHumidity() {
		return humidity;
	}

	public void setHumidity(BigDecimal humidity) {
		this.humidity = humidity;
	}

	public BigDecimal getTempMin() {
		return tempMin;
	}

	public void setTempMin(BigDecimal tempMin) {
		this.tempMin = tempMin;
	}

	public BigDecimal getTempMax() {
		return tempMax;
	}

	public void setTempMax(BigDecimal tempMax) {
		this.tempMax = tempMax;
	}

}
