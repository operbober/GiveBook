package by.givebook.entities;


import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by operb_000 on 27.02.2016.
 */
@MappedSuperclass
public class NamedEntity extends IdEntity {
    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
