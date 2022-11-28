package com.example.football.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "stat")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class StatDTO {

    @XmlElement(name = "passing")
    @NotNull
    @Positive
    private float passing;

    @XmlElement(name = "shooting")
    @NotNull
    @Positive
    private float shooting;

    @XmlElement(name = "endurance")
    @NotNull
    @Positive
    private float endurance;

    public StatDTO() {
    }

    public float getPassing() {
        return passing;
    }

    public void setPassing(float passing) {
        this.passing = passing;
    }

    public float getShooting() {
        return shooting;
    }

    public void setShooting(float shooting) {
        this.shooting = shooting;
    }

    public float getEndurance() {
        return endurance;
    }

    public void setEndurance(float endurance) {
        this.endurance = endurance;
    }
}
