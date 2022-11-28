package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import static softuni.exam.Constants.Regexes.EMAIL_REGEX;

@Entity
@Table(name = "agents")
public class Agent extends BaseEntity{

    @Column(name = "first_name", nullable = false, unique = true)
    @Size(min = 2)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Size(min = 2)
    private String lastName;

    @Column(name = "email", unique = true, nullable = false)
    @Email(regexp = EMAIL_REGEX)
    private String email;

    @ManyToOne
    private Town town;

    public Agent() {
        super();
    }

    public Agent(String firstName, String lastName, String email, Town town) {
        this();
        this.town = town;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
