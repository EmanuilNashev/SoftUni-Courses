package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "offers")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class ImportOfferRootDTO {

    @XmlElement(name = "offer")
    private List<ImportOfferDTO> offers;

    public ImportOfferRootDTO() {
    }

    public List<ImportOfferDTO> getOffers() {
        return offers;
    }

    public void setOffers(List<ImportOfferDTO> offers) {
        this.offers = offers;
    }
}
