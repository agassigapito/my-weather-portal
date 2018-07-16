package my.weather.portal;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author agassi.d.h.agapito
 *
 */
@EnableAutoConfiguration
@SpringBootApplication
public class MyWeatherPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyWeatherPortalApplication.class, args);
		BasicConfigurator.configure();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
