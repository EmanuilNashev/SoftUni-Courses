package softuni.exam.models.dto;

public class ApartmentAreaAndTownDTO {

    private double area;

    private TownNameDTO town;

    public ApartmentAreaAndTownDTO() {
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public TownNameDTO getTown() {
        return town;
    }

    public void setTown(TownNameDTO town) {
        this.town = town;
    }
}
