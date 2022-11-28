package com.example.football.service.impl;

import com.example.football.models.dto.PlayerRootDTO;
import com.example.football.models.entity.Player;
import com.example.football.models.entity.Stat;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.models.entity.enums.Position;
import com.example.football.repository.PlayerRepository;
import com.example.football.repository.StatRepository;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.PlayerService;
import com.example.football.util.ValidatorUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;

    private TownRepository townRepository;

    private TeamRepository teamRepository;

    private StatRepository statRepository;

    private XmlParser xmlParser;

    private ModelMapper modelMapper;

    private ValidatorUtil validatorUtil;

    public PlayerServiceImpl(PlayerRepository playerRepository, TownRepository townRepository, TeamRepository teamRepository, StatRepository statRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidatorUtil validatorUtil) {
        this.playerRepository = playerRepository;
        this.townRepository = townRepository;
        this.teamRepository = teamRepository;
        this.statRepository = statRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
    }

    @Override
    public boolean areImported() {
        return this.playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(Path.of("skeleton/src/main/resources/files/xml/players.xml"));
    }

    @Override
    public String importPlayers() throws JAXBException {
        StringBuilder output = new StringBuilder();

        this.xmlParser.parse("skeleton/src/main/resources/files/xml/players.xml", PlayerRootDTO.class).getPlayers()
                .stream().filter(playerDTO -> {
                    boolean isValid = this.validatorUtil.isValid(playerDTO);

                    boolean isInvalid = this.playerRepository.findByEmail(playerDTO.getEmail()).isPresent()
                            || !(playerDTO.getEmail().contains(".") && playerDTO.getEmail().contains("@"))
                            || !(playerDTO.getPosition().equals("ATT") || playerDTO.getPosition().equals("DEF")
                            || playerDTO.getPosition().equals("MID"));

                    if (isInvalid) {
                        isValid = false;
                    }

                    output.append(!isValid
                                    ? "Invalid Player"
                                    : "Successfully imported Player " + playerDTO.getFirstName() + " - "
                                    + playerDTO.getLastName() + " - " + playerDTO.getPosition())
                            .append(System.lineSeparator());

                    return isValid;
                }).map(playerDTO -> {
                    Player player = this.modelMapper.map(playerDTO, Player.class);

                    String formattedDate = getFormattedDate(playerDTO.getBirthDate());

                    player.setBirthDate(LocalDate.parse(formattedDate));

                    player.setPosition(Position.valueOf(playerDTO.getPosition()));

                    Optional<Town> town = this.townRepository.findByName(playerDTO.getTown().getName());

                    town.ifPresent(player::setTown);

                    Optional<Team> team = this.teamRepository.findByName(playerDTO.getTeam().getName());

                    team.ifPresent(player::setTeam);

                    Optional<Stat> stat = this.statRepository.findById((long)playerDTO.getStat().getId());

                    stat.ifPresent(player::setStat);

                    return player;
                }).forEach(playerRepository::save);

        return output.toString();
    }

    private String getFormattedDate(String birthDate) {

        return birthDate.split("/")[2] + "-" + birthDate.split("/")[1] + "-"
                + birthDate.split("/")[0];
    }

    @Override
    public String exportBestPlayers() {
        StringBuilder output = new StringBuilder();

        this.playerRepository.findAllByBirthdateAfterAndBirthdateBefore(1995, 2003)
                .forEach(p -> {
                    output.append("Player - ").append(p.getFirstName()).append(" ")
                            .append(p.getLastName()).append(System.lineSeparator())
                            .append("   ").append("Position - ").append(p.getPosition().name())
                            .append(System.lineSeparator()).append("   Team - ")
                            .append(p.getTeam().getName()).append(System.lineSeparator()).append("   Stadium")
                            .append(p.getTeam().getStadiumName()).append(System.lineSeparator());
                });


        return output.toString();
    }
}
