package softuni.exam.models.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "forecast")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class ForecastSeedDTO {

    @XmlElement(name = "day_of_week")
    @NotNull
    private String dayOfWeek;

    @XmlElement(name = "max_temperature")
    @Min(value = -20)
    @Max(value = 60)
    private double maxTemperature;

    @XmlElement(name = "min_temperature")
    @Min(value = -50)
    @Max(value = 40)
    private double minTemperature;

    @XmlElement(name = "sunrise")
    @NotNull
    private String sunrise;

    @XmlElement(name = "sunset")
    @NotNull
    private String sunset;

    @XmlElement(name = "city")
    private int city;

    public ForecastSeedDTO() {
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }
}
