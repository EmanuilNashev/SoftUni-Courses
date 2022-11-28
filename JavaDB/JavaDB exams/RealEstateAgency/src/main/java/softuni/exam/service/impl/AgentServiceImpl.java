package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportAgentDTO;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.AgentService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Set;

import static softuni.exam.Constants.Messages.INVALID_AGENT;
import static softuni.exam.Constants.Messages.SUCCESSFULLY_IMPORTED_AGENT;
import static softuni.exam.Constants.Paths.AGENTS_JSON_PATH;

@Service
public class AgentServiceImpl implements AgentService {

    private AgentRepository agentRepository;

    private Validator validator;

    private Gson gson;

    private ModelMapper modelMapper;

    private TownRepository townRepository;

    @Autowired
    public AgentServiceImpl(AgentRepository agentRepository, Validator validator, Gson gson, ModelMapper modelMapper, TownRepository townRepository) {
        this.agentRepository = agentRepository;
        this.validator = validator;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.townRepository = townRepository;
    }

    @Override
    public boolean areImported() {
        return this.agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return String.join(System.lineSeparator(), Files.readAllLines(Path.of(AGENTS_JSON_PATH)));
    }

    @Override
    public String importAgents() throws IOException {
        String agentsJson = readAgentsFromFile();

        ImportAgentDTO[] importAgentDTOS = this.gson.fromJson(agentsJson, ImportAgentDTO[].class);

        StringBuilder stringBuilder = new StringBuilder();

        for (ImportAgentDTO importAgentDTO : importAgentDTOS) {
            Set<ConstraintViolation<ImportAgentDTO>> validate = this.validator.validate(importAgentDTO);

            Optional<Agent> optAgent = this.agentRepository.findByFirstName(importAgentDTO.getFirstName());

            if (validate.isEmpty()) {
                if (optAgent.isEmpty()) {
                    Agent agent = this.modelMapper.map(importAgentDTO, Agent.class);

                    Optional<Town> optTown = this.townRepository.findByTownName(importAgentDTO.getTown());
                    optTown.ifPresent(agent::setTown);

                    this.agentRepository.saveAndFlush(agent);

                    stringBuilder.append(String.format(SUCCESSFULLY_IMPORTED_AGENT, agent.getFirstName(), agent.getLastName()));
                    stringBuilder.append(System.lineSeparator());

                } else {
                    stringBuilder.append(INVALID_AGENT).append(System.lineSeparator());
                }

            } else {
                stringBuilder.append(INVALID_AGENT).append(System.lineSeparator());
            }

        }

        return stringBuilder.toString();
    }
}
