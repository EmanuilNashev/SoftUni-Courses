package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CitySeedDTO;
import softuni.exam.models.entity.City;
import softuni.exam.repository.CityRepository;
import softuni.exam.service.CityService;
import softuni.exam.util.ValidatorUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static softuni.exam.constants.Messages.INVALID_CITY;
import static softuni.exam.constants.Messages.SUCCESSFULLY_IMPORTED_CITY;
import static softuni.exam.constants.Paths.CITIES_FILE_PATH;

@Service
public class CityServiceImpl implements CityService {

    private CityRepository cityRepository;

    private Gson gson;

    private ValidatorUtil validatorUtil;

    private ModelMapper modelMapper;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository, Gson gson, ValidatorUtil validatorUtil, ModelMapper modelMapper) {
        this.cityRepository = cityRepository;
        this.gson = gson;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.cityRepository.count() > 0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {
        return Files.readString(Path.of(CITIES_FILE_PATH));
    }

    @Override
    public String importCities() throws IOException {
        StringBuilder output = new StringBuilder();

        Arrays
                .stream(this.gson.fromJson(readCitiesFileContent(), CitySeedDTO[].class))
                .filter(citySeedDTO -> {
                    boolean isValid = this.validatorUtil.isValid(citySeedDTO);

                    if (this.cityRepository.findByCityName(citySeedDTO.getCityName()).isPresent()) {
                        isValid = false;
                    }

                    output.append(!isValid
                                    ? INVALID_CITY
                                    : String.format(SUCCESSFULLY_IMPORTED_CITY, citySeedDTO.getCityName(), citySeedDTO.getPopulation()))
                            .append(System.lineSeparator());

                    return isValid;
                }).map(citySeedDTO -> this.modelMapper.map(citySeedDTO, City.class))
                .forEach(cityRepository::save);

        return output.toString();
    }
}
