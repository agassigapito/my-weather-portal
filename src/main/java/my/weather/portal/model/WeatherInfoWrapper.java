package my.weather.portal.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author agassi.d.h.agapito
 *
 */
public class WeatherInfoWrapper implements Serializable {

	private static final long serialVersionUID = 8302987816726710406L;

	@JsonProperty("weather")
	private Set<Weather> weathers = new HashSet<Weather>();

	@JsonProperty("main")
	private MainInfo mainInfo;

	@JsonProperty("name")
	private String locationName;

	public Set<Weather> getWeathers() {
		return weathers;
	}

	public void setWeathers(Set<Weather> weathers) {
		this.weathers = weathers;
	}

	public MainInfo getMainInfo() {
		return mainInfo;
	}

	public void setMainInfo(MainInfo mainInfo) {
		this.mainInfo = mainInfo;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

}
