package my.weather.portal.model;

import java.io.Serializable;

/**
 *
 * @author agassi.d.h.agapito
 *
 */
public class Weather implements Serializable {

	private static final long serialVersionUID = -8273239231034622306L;

	private long id;
	private String main;
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
