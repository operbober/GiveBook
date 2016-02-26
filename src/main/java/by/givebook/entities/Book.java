package by.givebook.entities;

import by.givebook.entities.superEntity.IdEntity;

import javax.persistence.*;

/**
 * Default class description.
 *
 * @author P.Sinitski
 * @version 1.0
 * @since 26.02.2016
 */
@Entity
@Table(name = "book")
public class Book extends IdEntity{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
