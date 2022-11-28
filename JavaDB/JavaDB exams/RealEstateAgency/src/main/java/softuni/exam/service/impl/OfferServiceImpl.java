package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ExportOfferDTO;
import softuni.exam.models.dto.ImportOfferDTO;
import softuni.exam.models.dto.ImportOfferRootDTO;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.OfferService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static softuni.exam.Constants.Messages.INVALID_OFFER;
import static softuni.exam.Constants.Messages.SUCCESSFULLY_IMPORTED_OFFER;
import static softuni.exam.Constants.Paths.OFFER_XML_PATH;

@Service
public class OfferServiceImpl implements OfferService {

    private OfferRepository offerRepository;

    private AgentRepository agentRepository;

    private ApartmentRepository apartmentRepository;

    private TownRepository townRepository;

    private Validator validator;

    private ModelMapper modelMapper;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, AgentRepository agentRepository, ApartmentRepository apartmentRepository, TownRepository townRepository, Validator validator, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.agentRepository = agentRepository;
        this.apartmentRepository = apartmentRepository;
        this.townRepository = townRepository;
        this.validator = validator;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return String.join(System.lineSeparator(), Files.readAllLines(Path.of(OFFER_XML_PATH)));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {

        JAXBContext context = JAXBContext.newInstance(ImportOfferRootDTO.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        ImportOfferRootDTO importOfferRootDTO = (ImportOfferRootDTO) unmarshaller.unmarshal(new File(OFFER_XML_PATH));

        List<ImportOfferDTO> importOfferDTOS = importOfferRootDTO.getOffers();

        StringBuilder stringBuilder = new StringBuilder();

        for (ImportOfferDTO importOfferDTO : importOfferDTOS) {
            Set<ConstraintViolation<ImportOfferDTO>> validate = this.validator.validate(importOfferDTO);

            if (validate.isEmpty()) {
                Optional<Agent> optAgent = this.agentRepository.findByFirstName(importOfferDTO.getAgent().getName());

                if (optAgent.isPresent()) {
                    Offer offer = this.modelMapper.map(importOfferDTO, Offer.class);

                    Optional<Agent> agent = this.agentRepository.findByFirstName(importOfferDTO.getAgent().getName());

                    Optional<Apartment> apartment = this.apartmentRepository.findById(importOfferDTO.getApartment().getId());

                    String formattedDateString = getFormattedDate(importOfferDTO.getPublishedOn());
                    LocalDate date = LocalDate.parse(formattedDateString);

                    agent.ifPresent(offer::setAgent);
                    apartment.ifPresent(offer::setApartment);

                    offer.setPublishedOn(date);

                    this.offerRepository.saveAndFlush(offer);

                    stringBuilder.append(String.format(SUCCESSFULLY_IMPORTED_OFFER, offer.getPrice()));
                    stringBuilder.append(System.lineSeparator());


                } else {
                    stringBuilder.append(INVALID_OFFER).append(System.lineSeparator());
                }

            } else {
                stringBuilder.append(INVALID_OFFER).append(System.lineSeparator());
            }
        }

        return stringBuilder.toString();
    }

    private String getFormattedDate(String publishedOn) {
        String[] arr = publishedOn.split("/");
        return arr[2] + "-" + arr[1] + "-" + arr[0];
    }

    @Override
    public String exportOffers() {

        List<Offer> offers = this.offerRepository.findAll()
                .stream()
                .filter(offer -> offer.getApartment().getApartmentType().ordinal() == 1)
                .sorted((offer1, offer2) -> Double.compare(offer2.getApartment().getArea(), offer1.getApartment().getArea()))
                .sorted((Comparator.comparing(Offer::getPrice))).collect(Collectors.toList());

        StringBuilder stringBuilder = new StringBuilder();

        for (Offer offer : offers) {
            ExportOfferDTO exportOfferDTO = this.modelMapper.map(offer, ExportOfferDTO.class);

           stringBuilder.append(exportOfferDTO.toString()).append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }
}
