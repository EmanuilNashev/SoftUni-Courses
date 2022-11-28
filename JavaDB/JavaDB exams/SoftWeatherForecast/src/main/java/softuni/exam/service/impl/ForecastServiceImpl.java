package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ExportForecastDTO;
import softuni.exam.models.dto.ForecastSeedRootDTO;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Forecast;
import softuni.exam.models.entity.enums.DayOfWeek;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.ForecastService;
import softuni.exam.util.ValidatorUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static softuni.exam.constants.Messages.INVALID_FORECAST;
import static softuni.exam.constants.Messages.SUCCESSFULLY_IMPORTED_FORECAST;
import static softuni.exam.constants.Paths.FORECASTS_FILE_PATH;

@Service
public class ForecastServiceImpl implements ForecastService {

    private ForecastRepository forecastRepository;

    private CityRepository cityRepository;

    private ValidatorUtil validatorUtil;

    private ModelMapper modelMapper;

    private XmlParser xmlParser;

    @Autowired
    public ForecastServiceImpl(ForecastRepository forecastRepository, CityRepository cityRepository, ValidatorUtil validatorUtil, ModelMapper modelMapper, XmlParser xmlParser) {
        this.forecastRepository = forecastRepository;
        this.cityRepository = cityRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return this.forecastRepository.count() > 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {
        return Files.readString(Path.of(FORECASTS_FILE_PATH));
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {
        StringBuilder output = new StringBuilder();

        this.xmlParser.parse(FORECASTS_FILE_PATH, ForecastSeedRootDTO.class).getForecasts()
                .stream().filter(forecastSeedDTO -> {
                    boolean isValid = this.validatorUtil.isValid(forecastSeedDTO);

                    if (this.forecastRepository
                            .findForecastWithSameDayOfWeekSndCity(forecastSeedDTO.getDayOfWeek(), forecastSeedDTO.getCity()).isPresent() || forecastSeedDTO.getDayOfWeek().equals("NULL")) {
                        isValid = false;
                    }

                    output.append(!isValid
                                    ? INVALID_FORECAST
                                    : String.format(SUCCESSFULLY_IMPORTED_FORECAST, forecastSeedDTO.getDayOfWeek(), forecastSeedDTO.getMaxTemperature()))
                            .append(System.lineSeparator());

                    return isValid;
                }).map(forecastSeedDTO -> {
                    Forecast forecast = this.modelMapper.map(forecastSeedDTO, Forecast.class);

                    forecast.setDayOfWeek(DayOfWeek.valueOf(forecastSeedDTO.getDayOfWeek()));
                    forecast.setSunrise(LocalTime.parse(forecastSeedDTO.getSunrise()));
                    forecast.setSunset(LocalTime.parse(forecastSeedDTO.getSunset()));

                    Optional<City> city = this.cityRepository.findById((long) forecastSeedDTO.getCity());

                    city.ifPresent(forecast::setCity);

                    return forecast;
                }).forEach(this.forecastRepository::save);


        return output.toString();
    }

    @Override
    public String exportForecasts() {
        StringBuilder output = new StringBuilder();

        this.forecastRepository
                .findForecastsByDayOfWeekAndCityPopulationLessThanOrderByMaxTemperatureDescThenByIdAsc
                        ("SUNDAY", 150000)
                .stream().map(forecast -> this.modelMapper.map(forecast, ExportForecastDTO.class))
                .forEach(exportForecastDTO -> output.append(exportForecastDTO).append(System.lineSeparator()));

        return output.toString().trim();
    }
}
