package softuni.exam.models.dto;

import java.math.BigDecimal;

public class ExportOfferDTO {

    private Long id;

    private BigDecimal price;

    private AgentFullNameDTO agent;

    private ApartmentAreaAndTownDTO apartment;

    public ExportOfferDTO() {
    }

    public ExportOfferDTO(Long id, BigDecimal price, AgentFullNameDTO agent, ApartmentAreaAndTownDTO apartment) {
        this.id = id;
        this.price = price;
        this.agent = agent;
        this.apartment = apartment;
    }

    public AgentFullNameDTO getAgent() {
        return agent;
    }

    public void setAgent(AgentFullNameDTO agent) {
        this.agent = agent;
    }

    public ApartmentAreaAndTownDTO getApartment() {
        return apartment;
    }

    public void setApartment(ApartmentAreaAndTownDTO apartment) {
        this.apartment = apartment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Agent " + this.getAgent().getFirstName() + " " + this.getAgent().getLastName()
                + " with offer №" + this.getId() + ":"
                + System.lineSeparator()
                + "        -Apartment area: " + String.format("%.2f", this.getApartment().getArea()) + System.lineSeparator()
                + "        --Town: " + this.getApartment().getTown().getTownName() + System.lineSeparator()
                + "        ---Price: " + String.format("%.2f", this.getPrice()) + "$";
    }
}
