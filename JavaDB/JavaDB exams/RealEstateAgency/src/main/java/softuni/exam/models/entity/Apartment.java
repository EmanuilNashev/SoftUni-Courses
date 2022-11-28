package softuni.exam.models.entity;

import softuni.exam.models.entity.enums.ApartmentType;

import javax.persistence.*;
import javax.validation.constraints.Min;

import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "apartments")
public class Apartment extends BaseEntity{

    @Column(name = "apartment_type", nullable = false)
    @Enumerated(STRING)
    private ApartmentType apartmentType;

    @Column(name = "area", nullable = false)
    @Min(40)
    private double area;

    @ManyToOne
    private Town town;

    public Apartment() {
        super();
    }

    public Apartment(ApartmentType apartmentType, double area, Town town) {
        this();
        this.town = town;
        this.apartmentType = apartmentType;
        this.area = area;
    }

    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
