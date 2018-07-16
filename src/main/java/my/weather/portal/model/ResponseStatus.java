package my.weather.portal.model;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 * @author agassi.d.h.agapito
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class ResponseStatus implements Serializable {

	private static final long serialVersionUID = 7257900574799658835L;

	@JsonProperty("Status")
	private String status;

	@JsonProperty("StatusCode")
	private String statusCode;

	@JsonProperty("StatusMessage")
	private String statusMessage;


	public ResponseStatus() {}
	public ResponseStatus(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public ResponseStatus(HttpStatus httpStatus, String statusMessage) {
		this.status = httpStatus.value() +"";
		this.statusCode = httpStatus.getReasonPhrase();
		this.statusMessage = statusMessage;
	}
	public ResponseStatus(String status, String statusCode, String statusMessage) {
		this.status = status;
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
}
