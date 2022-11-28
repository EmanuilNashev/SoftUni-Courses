package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CountrySeedDTO;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidatorUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static softuni.exam.constants.Messages.INVALID_COUNTRY;
import static softuni.exam.constants.Messages.SUCCESSFULLY_IMPORTED_COUNTRY;
import static softuni.exam.constants.Paths.COUNTRIES_FILE_PATH;

@Service
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;

    private Gson gson;

    private ValidatorUtil validatorUtil;

    private ModelMapper modelMapper;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository, Gson gson, ValidatorUtil validatorUtil, ModelMapper modelMapper) {
        this.countryRepository = countryRepository;
        this.gson = gson;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return Files.readString(Path.of(COUNTRIES_FILE_PATH));
    }

    @Override
    public String importCountries() throws IOException {
        StringBuilder output = new StringBuilder();

        Arrays
                .stream(this.gson.fromJson(readCountriesFromFile(), CountrySeedDTO[].class))
                .filter(countrySeedDTO -> {
                    boolean isValid = this.validatorUtil.isValid(countrySeedDTO);

                    boolean invalidValidParameters = countrySeedDTO.getCountryName() == null
                            || countrySeedDTO.getCurrency() == null
                            || this.countryRepository.findByCountryName(countrySeedDTO.getCountryName()).isPresent();

                    if (invalidValidParameters) {
                        isValid = false;
                    }

                    output.append(!isValid
                                    ? INVALID_COUNTRY
                                    : String.format(SUCCESSFULLY_IMPORTED_COUNTRY,
                                    countrySeedDTO.getCountryName(),
                                    countrySeedDTO.getCurrency()))
                            .append(System.lineSeparator());

                    return isValid;
                }).map(countrySeedDTO -> this.modelMapper.map(countrySeedDTO, Country.class))
                .forEach(countryRepository::save);


        return output.toString();
    }
}
