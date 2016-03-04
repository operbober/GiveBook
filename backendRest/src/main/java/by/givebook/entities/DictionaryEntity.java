package by.givebook.entities;


import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by operb_000 on 27.02.2016.
 */
@MappedSuperclass
public class DictionaryEntity extends IdEntity {
    @Column(name = "name")
    public String name;
}
