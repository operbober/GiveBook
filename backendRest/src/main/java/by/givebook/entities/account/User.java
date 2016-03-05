package by.givebook.entities.account;

import by.givebook.entities.offer.Offer;
import by.givebook.entities.IdEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


/**
 * Created by operb_000 on 09.10.2015.
 */
@Entity
@Table(name = "user")
public class User extends IdEntity{

    public String login;
    public String password;
    public String email;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    public Person person;

    @ManyToMany
    @JoinTable(name = "users_roles",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> roles;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    public List<Offer> offers;
}
