package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "countries")
public class Country extends BaseEntity{

    @Column(name = "country_name", unique = true, nullable = false)
    @Size(min = 2, max = 60)
    private String countryName;

    @Column(name = "currency", nullable = false)
    @Size(min = 2, max = 20)
    private String currency;

    public Country() {
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
