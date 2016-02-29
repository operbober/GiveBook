package by.givebook.entities;

import by.givebook.entities.superEntity.IdEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;


/**
 * Created by operb_000 on 28.02.2016.
 */
@Entity
@Table(name = "author")
public class Author extends IdEntity {
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY)
    private List<Work> works;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Work> getWorks() {
        return works;
    }

    public void setWorks(List<Work> works) {
        this.works = works;
    }
}
