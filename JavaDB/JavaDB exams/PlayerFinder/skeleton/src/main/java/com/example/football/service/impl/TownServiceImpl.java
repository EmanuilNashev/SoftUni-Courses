package com.example.football.service.impl;

import com.example.football.models.dto.TownDTO;
import com.example.football.models.entity.Town;
import com.example.football.repository.TownRepository;
import com.example.football.service.TownService;
import com.example.football.util.ValidatorUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;


@Service
public class TownServiceImpl implements TownService {

    private TownRepository townRepository;

    private Gson gson;

    private ModelMapper modelMapper;

    private ValidatorUtil validatorUtil;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, Gson gson, ModelMapper modelMapper, ValidatorUtil validatorUtil) {
        this.townRepository = townRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
    }

    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of("skeleton/src/main/resources/files/json/towns.json"));
    }

    @Override
    public String importTowns() throws IOException {
        StringBuilder output = new StringBuilder();

        Arrays.stream(this.gson.fromJson(readTownsFileContent(), TownDTO[].class))
                .filter(townDTO -> {
                    boolean isValid = this.validatorUtil.isValid(townDTO);

                    if (this.townRepository.findByName(townDTO.getName()).isPresent()) {
                        isValid = false;
                    }

                    output.append(!isValid ?
                                    "Invalid town"
                                    : "Successfully imported town " + townDTO.getName() + " - " + townDTO.getPopulation())
                            .append(System.lineSeparator());

                    return isValid;
                }).map(townDTO -> this.modelMapper.map(townDTO, Town.class))
                .forEach(townRepository::save);

        return output.toString();
    }
}
