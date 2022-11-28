package com.example.football.service.impl;

import com.example.football.models.dto.TeamDTO;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.TeamService;
import com.example.football.util.ValidatorUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    private TeamRepository teamRepository;

    private TownRepository townRepository;

    private Gson gson;

    private ValidatorUtil validatorUtil;

    private ModelMapper modelMapper;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, TownRepository townRepository, Gson gson, ValidatorUtil validatorUtil, ModelMapper modelMapper) {
        this.teamRepository = teamRepository;
        this.townRepository = townRepository;
        this.gson = gson;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files.readString(Path.of("skeleton/src/main/resources/files/json/teams.json"));
    }

    @Override
    public String importTeams() throws IOException {
        StringBuilder output = new StringBuilder();

        Arrays.stream(this.gson.fromJson(readTeamsFileContent(), TeamDTO[].class))
                .filter(teamDTO -> {
                    boolean isValid = this.validatorUtil.isValid(teamDTO);

                    if (this.teamRepository.findByName(teamDTO.getName()).isPresent()) {
                        isValid = false;
                    }

                    output.append(!isValid
                                    ? "Invalid team"
                                    : "Successfully imported team " + teamDTO.getName() + " - " + teamDTO.getFanBase())
                            .append(System.lineSeparator());


                    return isValid;
                }).map(teamDTO -> {
                    Team team = this.modelMapper.map(teamDTO, Team.class);

                    Optional<Town> town = this.townRepository.findByName(teamDTO.getTownName());
                    town.ifPresent(team::setTown);

                    return team;
                })
                .forEach(teamRepository::save);

        return output.toString();
    }
}
