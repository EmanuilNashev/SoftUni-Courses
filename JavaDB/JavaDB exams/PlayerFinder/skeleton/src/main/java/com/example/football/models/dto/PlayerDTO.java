package com.example.football.models.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "player")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class PlayerDTO {

    @XmlElement(name = "first-name")
    @Size(min = 3)
    @NotNull
    private String firstName;

    @XmlElement(name = "last-name")
    @NotNull
    @Size(min = 3)
    private String lastName;

    @XmlElement(name = "email")
    @Email(regexp = "^\\w+@\\w+\\.\\w+$")
    @NotNull
    private String email;

    @XmlElement(name = "birth-date")
    @NotNull
    private String birthDate;

    @XmlElement(name = "position")
    @NotNull
    private String position;

    @XmlElement(name = "town")
    private TownNameDTO town;

    @XmlElement(name = "team")
    private TeamNameDTO team;

    @XmlElement(name = "stat")
    private StatIdDTO stat;

    public PlayerDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public TownNameDTO getTown() {
        return town;
    }

    public void setTown(TownNameDTO town) {
        this.town = town;
    }

    public TeamNameDTO getTeam() {
        return team;
    }

    public void setTeam(TeamNameDTO team) {
        this.team = team;
    }

    public StatIdDTO getStat() {
        return stat;
    }

    public void setStat(StatIdDTO stat) {
        this.stat = stat;
    }
}
