package by.givebook.entities.library;

import by.givebook.entities.IdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Default class description.
 *
 * @author P.Sinitsky.
 * @date 11.05.2016.
 */
@Entity
@Table(name = "quote")
public class Quote extends IdEntity {

    @Column(name = "quote")
    private String quote;

    @Column(name = "author")
    private String author;

    public String getQuote() {
        return quote;
    }

    public String getAuthor() {
        return author;
    }
}
