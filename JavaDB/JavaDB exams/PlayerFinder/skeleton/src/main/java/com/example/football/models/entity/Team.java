package com.example.football.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "teams")
public class Team extends BaseEntity{

    @Column(name = "name", nullable = false, unique = true)
    @NotNull
    @Size(min = 3)
    private String name;

    @Column(name = "stadium_name", nullable = false)
    @NotNull
    @Size(min = 3)
    private String stadiumName;

    @Column(name = "fan_base", nullable = false)
    @NotNull
    @Min(value = 1000)
    private int fanBase;

    @Column(name = "history", nullable = false, columnDefinition = "TEXT")
    @NotNull
    @Size(min = 10)
    private String history;

    @ManyToOne
    private Town town;

    public Team() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public int getFanBase() {
        return fanBase;
    }

    public void setFanBase(int fanBase) {
        this.fanBase = fanBase;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
