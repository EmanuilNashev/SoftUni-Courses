package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "apartments")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class ImportApartmentRootDTO {

    @XmlElement(name = "apartment")
    private List<ImportApartmentDTO> apartments;

    public ImportApartmentRootDTO() {
    }

    public List<ImportApartmentDTO> getApartments() {
        return apartments;
    }

    public void setApartments(List<ImportApartmentDTO> apartments) {
        this.apartments = apartments;
    }
}
