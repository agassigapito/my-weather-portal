package my.weather.portal.constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author agassi.d.h.agapito
 *
 */
public final class Constants {

	private Constants() {
	}

	public static final String PARAM_Q = "q";
	public static final String APPID = "APPID";
	public static final String ENTRY_METHOD = "Entry Method: ";
	public static final String EXIT_METHOD = "Exit Method: ";
	public static final List<String> TARGET_CITIES = Collections.unmodifiableList(new ArrayList<String>() {
		private static final long serialVersionUID = 7980092511686554877L;
		{
			add("London");
			add("Prague");
			add("San Francisco");
		}
	});
}
