package com.example.football.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "stats")
public class Stat extends BaseEntity{

    @Column(name = "shooting", nullable = false)
    @NotNull
    @Positive
    private float shooting;

    @Column(name = "passing", nullable = false)
    @NotNull
    @Positive
    private float passing;

    @Column(name = "endurance", nullable = false)
    @NotNull
    @Positive
    private float endurance;

    public Stat() {
        super();
    }

    public float getShooting() {
        return shooting;
    }

    public void setShooting(float shooting) {
        this.shooting = shooting;
    }

    public float getPassing() {
        return passing;
    }

    public void setPassing(float passing) {
        this.passing = passing;
    }

    public float getEndurance() {
        return endurance;
    }

    public void setEndurance(float endurance) {
        this.endurance = endurance;
    }
}
