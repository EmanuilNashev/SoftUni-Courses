package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity{

    @Column(name = "town_name", unique = true, nullable = false)
    @Size(min = 2)
    private String townName;

    @Column(name = "population", nullable = false)
    @Positive
    private int population;

    public Town() {
        super();
    }

    public Town(String townName, int population) {
        this();
        this.townName = townName;
        this.population = population;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Town)) return false;
        Town town = (Town) o;
        return Objects.equals(getTownName(), town.getTownName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTownName());
    }
}
