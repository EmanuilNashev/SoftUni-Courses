package com.example.football.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity{

    @Column(name = "name", unique = true, nullable = false)
    @Size(min = 2)
    @NotNull
    private String name;

    @Column(name = "population", nullable = false)
    @Positive
    @NotNull
    private int population;

    @Column(name = "travel_guide", columnDefinition = "TEXT", nullable = false)
    @NotNull
    @Size(min = 10)
    private String travelGuide;

    public Town() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getTravelGuide() {
        return travelGuide;
    }

    public void setTravelGuide(String travelGuide) {
        this.travelGuide = travelGuide;
    }
}
