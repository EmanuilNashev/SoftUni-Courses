package softuni.exam.models.entity;

import org.hibernate.annotations.Fetch;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cities")
public class City extends BaseEntity{

    @Column(name = "city_name", unique = true, nullable = false)
    @Size(min = 2, max = 60)
    private String cityName;

    @Column(name = "description", columnDefinition = "TEXT")
    @Size(min = 2)
    private String description;

    @Column(name = "population", nullable = false)
    @Min(value = 500)
    private int population;

    @ManyToOne
    private Country country;

    public City() {
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
