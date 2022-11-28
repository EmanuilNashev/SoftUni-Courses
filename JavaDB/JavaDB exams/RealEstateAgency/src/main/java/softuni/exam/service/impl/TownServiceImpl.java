package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportTownDTO;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static softuni.exam.Constants.Messages.INVALID_TOWN;
import static softuni.exam.Constants.Messages.SUCCESSFULLY_IMPORTED_TOWN;
import static softuni.exam.Constants.Paths.TOWNS_JSON_PATH;

@Service
public class TownServiceImpl implements TownService {

    private TownRepository townRepository;

    private final Validator validator;

    private Gson gson;

    private ModelMapper modelMapper;


    @Autowired
    public TownServiceImpl(TownRepository townRepository, Gson gson, Validator validator, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.validator = validator;
        this.townRepository = townRepository;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return String.join(System.lineSeparator(), Files.readAllLines(Path.of(TOWNS_JSON_PATH)));
    }

    @Override
    public String importTowns() throws IOException {
        final String townsJson = readTownsFileContent();

        StringBuilder messages = new StringBuilder();

        ImportTownDTO[] importTownDTOS = this.gson.fromJson(townsJson, ImportTownDTO[].class);

        for (ImportTownDTO importTownDTO : importTownDTOS) {
            Set<ConstraintViolation<ImportTownDTO>> validate = this.validator.validate(importTownDTO);

            if (validate.isEmpty()) {
                Optional<Town> optTown = this.townRepository.findByTownName(importTownDTO.getTownName());

                if (optTown.isEmpty()){
                    Town town = this.modelMapper.map(importTownDTO, Town.class);
                    this.townRepository.saveAndFlush(town);
                    messages.append(String.format(SUCCESSFULLY_IMPORTED_TOWN, town.getTownName(), town.getPopulation()));
                    messages.append(System.lineSeparator());
                }else {
                    messages.append(INVALID_TOWN).append(System.lineSeparator());
                }

            } else {
                messages.append(INVALID_TOWN).append(System.lineSeparator());
            }
        }

        return messages.toString();
    }
}
