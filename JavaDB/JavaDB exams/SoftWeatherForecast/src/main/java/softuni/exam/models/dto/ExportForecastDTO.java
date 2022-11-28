package softuni.exam.models.dto;

import softuni.exam.models.entity.City;

import java.time.LocalTime;

public class ExportForecastDTO {

    private City city;

    private double minTemperature;

    private double maxTemperature;

    private LocalTime sunrise;

    private LocalTime sunset;

    public ExportForecastDTO() {
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public LocalTime getSunrise() {
        return sunrise;
    }

    public void setSunrise(LocalTime sunrise) {
        this.sunrise = sunrise;
    }

    public LocalTime getSunset() {
        return sunset;
    }

    public void setSunset(LocalTime sunset) {
        this.sunset = sunset;
    }

    @Override
    public String toString() {
        return "City: " + this.getCity().getCityName() + ":"
                + System.lineSeparator()
                + "     -min temperature: " + String.format("%.2f", this.getMinTemperature())
                +System.lineSeparator()
                + "     --max temperature: " + String.format("%.2f", this.getMaxTemperature())
                +System.lineSeparator()
                + "     ---sunrise: " + this.getSunrise()
                + System.lineSeparator()
                + "     ----sunset: " + this.getSunset();

    }
}
