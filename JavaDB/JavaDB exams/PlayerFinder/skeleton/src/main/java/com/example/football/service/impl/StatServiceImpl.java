package com.example.football.service.impl;

import com.example.football.models.dto.StatRootDTO;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.ValidatorUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class StatServiceImpl implements StatService {

    private StatRepository statRepository;

    private ValidatorUtil validatorUtil;

    private ModelMapper modelMapper;

    private XmlParser xmlParser;

    @Autowired
    public StatServiceImpl(StatRepository statRepository, ValidatorUtil validatorUtil, ModelMapper modelMapper, XmlParser xmlParser) {
        this.statRepository = statRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return this.statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return Files.readString(Path.of("skeleton/src/main/resources/files/xml/stats.xml"));
    }

    @Override
    public String importStats() throws JAXBException {
        StringBuilder output = new StringBuilder();

        this.xmlParser.parse("skeleton/src/main/resources/files/xml/stats.xml", StatRootDTO.class)
                .getStats().stream().filter(statDTO -> {
                    boolean isValid = this.validatorUtil.isValid(statDTO);

                    if (this.statRepository.findByStats(statDTO.getShooting(), statDTO.getPassing(), statDTO.getEndurance()).isPresent()) {
                        isValid = false;
                    }

                    output.append(!isValid
                                    ? "Invalid stat"
                                    : "Successfully imported stat " + statDTO.getPassing() + "-" + statDTO.getShooting() + "-" + statDTO.getEndurance())
                            .append(System.lineSeparator());
                    return isValid;
                }).map(statDTO -> this.modelMapper.map(statDTO, Stat.class))
                .forEach(statRepository::save);


        return output.toString();
    }
}
