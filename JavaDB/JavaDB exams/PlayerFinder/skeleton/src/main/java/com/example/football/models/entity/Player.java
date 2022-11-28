package com.example.football.models.entity;

import com.example.football.models.entity.enums.Position;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "players")
public class Player extends BaseEntity{

    @Column(name = "first_name", nullable = false)
    @Size(min = 3)
    @NotNull
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotNull
    @Size(min = 3)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    @Email(regexp = "^\\w+@\\w+\\.\\w+$")
    @NotNull
    private String email;

    @Column(name = "birth_date", nullable = false)
    @NotNull
    private LocalDate birthDate;

    @Column(name = "position", nullable = false)
    @Enumerated
    @NotNull
    private Position position;

    @ManyToOne
    private Town town;

    @ManyToOne
    private Team team;

    @OneToOne
    private Stat stat;

    public Player() {
        super();
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Stat getStat() {
        return stat;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }
}
