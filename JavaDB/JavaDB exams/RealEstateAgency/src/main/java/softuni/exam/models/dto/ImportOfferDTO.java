package softuni.exam.models.dto;

import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "offer")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class ImportOfferDTO {

    //todo check later
    @XmlElement
    @Positive
    private BigDecimal price;

    @XmlElement
    private AgentNameDTO agent;

    @XmlElement
    private ApartmentIdDTO apartment;

    @XmlElement
    private String publishedOn;

    public ImportOfferDTO() {
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public AgentNameDTO getAgent() {
        return agent;
    }

    public void setAgent(AgentNameDTO agent) {
        this.agent = agent;
    }

    public ApartmentIdDTO getApartment() {
        return apartment;
    }

    public void setApartment(ApartmentIdDTO apartment) {
        this.apartment = apartment;
    }

    public String getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(String publishedOn) {
        this.publishedOn = publishedOn;
    }
}
