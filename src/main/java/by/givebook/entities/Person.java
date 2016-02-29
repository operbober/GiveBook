package by.givebook.entities;

import by.givebook.entities.superEntity.IdEntity;

import javax.persistence.*;


/**
 * Created by operb_000 on 27.02.2016.
 */
@Entity
@Table(name = "person")
public class Person extends IdEntity {
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "middle_name")
    private String middlename;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}