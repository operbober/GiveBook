package by.givebook.entities.library;

import by.givebook.entities.IdEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


/**
 * Created by operb_000 on 28.02.2016.
 */
@Entity
@Table(name = "author")
public class Author extends IdEntity {
    @Column(name = "last_name")
    public String lastName;

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "middle_name")
    public String middleName;

    @JsonIgnore
    @ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY)
    public List<Work> works;
}
