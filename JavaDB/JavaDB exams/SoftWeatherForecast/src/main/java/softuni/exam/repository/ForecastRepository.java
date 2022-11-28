package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Forecast;

import java.util.List;
import java.util.Optional;

@Repository
public interface ForecastRepository extends JpaRepository<Forecast, Long> {

    @Query(value = "SELECT * FROM forecasts AS f " +
            "WHERE f.day_of_week = ?1 AND f.city_id = ?2", nativeQuery = true)
    Optional<Forecast> findForecastWithSameDayOfWeekSndCity(String dayOfWeek, int cityId);

    @Query(value = "SELECT * " +
            "FROM forecasts AS f " +
            "JOIN cities AS c ON c.id = f.city_id " +
            "WHERE f.day_of_week = ?1 AND c.population < ?2 " +
            "ORDER BY f.max_temperature DESC, f.id" , nativeQuery = true)
    List<Forecast> findForecastsByDayOfWeekAndCityPopulationLessThanOrderByMaxTemperatureDescThenByIdAsc(String dayOfWeek, int population);



}
