package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CitySeedDTO {

    @Expose
    @Size(min = 2, max = 60)
    @NotNull
    private String cityName;

    @Expose
    @Size(min = 2)
    private String description;

    @Expose
    @Min(value = 500)
    @NotNull
    private int population;

    @Expose
    private int country;

    public CitySeedDTO() {
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

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }
}
