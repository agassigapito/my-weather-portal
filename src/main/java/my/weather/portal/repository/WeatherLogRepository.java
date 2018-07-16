package my.weather.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.weather.portal.entity.WeatherLog;

/**
 *
 * @author agassi.d.h.agapito
 *
 */
@Repository
public interface WeatherLogRepository extends JpaRepository<WeatherLog, Long>{

}
