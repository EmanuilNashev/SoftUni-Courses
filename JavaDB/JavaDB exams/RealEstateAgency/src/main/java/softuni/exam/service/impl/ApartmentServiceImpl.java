package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportApartmentDTO;
import softuni.exam.models.dto.ImportApartmentRootDTO;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Town;
import softuni.exam.models.entity.enums.ApartmentType;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.ApartmentService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static softuni.exam.Constants.Messages.INVALID_APARTMENT;
import static softuni.exam.Constants.Messages.SUCCESSFULLY_IMPORTED_APARTMENT;
import static softuni.exam.Constants.Paths.APARTMENT_XML_PATH;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    private ApartmentRepository apartmentRepository;

    private TownRepository townRepository;

    private Validator validator;

    private ModelMapper modelMapper;

    @Autowired
    public ApartmentServiceImpl(ApartmentRepository apartmentRepository, TownRepository townRepository, Validator validator, ModelMapper modelMapper) {
        this.apartmentRepository = apartmentRepository;
        this.townRepository = townRepository;
        this.validator = validator;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.apartmentRepository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return String.join(System.lineSeparator(), Files.readAllLines(Path.of(APARTMENT_XML_PATH)));
    }

    @Override
    public String importApartments() throws IOException, JAXBException {

        JAXBContext context = JAXBContext.newInstance(ImportApartmentRootDTO.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        ImportApartmentRootDTO importApartmentRootDTO = (ImportApartmentRootDTO) unmarshaller.unmarshal(new File(APARTMENT_XML_PATH));

        List<ImportApartmentDTO> importApartmentDTOS = importApartmentRootDTO.getApartments();

        StringBuilder stringBuilder = new StringBuilder();

        for (ImportApartmentDTO importApartmentDTO : importApartmentDTOS) {
            Set<ConstraintViolation<ImportApartmentDTO>> validate = this.validator.validate(importApartmentDTO);

            if (validate.isEmpty()) {
                Optional<Town> optTown = this.townRepository.findByTownName(importApartmentDTO.getTown());

                if (optTown.isPresent()) {
                    Optional<List<Apartment>> optApartments = this.apartmentRepository.findByTown(optTown.get());

                    if (optApartments.isPresent()) {
                        boolean flag = false;
                        for (Apartment apartment : optApartments.get()) {
                            if (apartment.getArea() == importApartmentDTO.getArea()) {
                                stringBuilder.append(INVALID_APARTMENT).append(System.lineSeparator());
                                flag = true;
                                break;
                            }
                        }
                        if (flag){
                            continue;
                        }
                    }
                }

                Apartment apartment = this.modelMapper.map(importApartmentDTO, Apartment.class);

                optTown.ifPresent(apartment::setTown);
                apartment.setApartmentType(ApartmentType.valueOf(importApartmentDTO.getApartmentType().toUpperCase()));
                this.apartmentRepository.saveAndFlush(apartment);

                stringBuilder.append(String.format(SUCCESSFULLY_IMPORTED_APARTMENT, apartment.getApartmentType().toString().toLowerCase(), apartment.getArea()));
                stringBuilder.append(System.lineSeparator());


            } else {
                stringBuilder.append(INVALID_APARTMENT).append(System.lineSeparator());
            }
        }

        return stringBuilder.toString();
    }
}
