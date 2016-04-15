package by.givebook.entities.offer;

import by.givebook.entities.library.Work;
import by.givebook.entities.IdEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by operb_000 on 29.02.2016.
 */
@Entity
@Table
public class Book extends IdEntity {

    @NotNull
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_work",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns= @JoinColumn(name = "work_id"))
    private List<Work> works;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private BookLanguage bookLanguage;

    @ManyToOne
    @JoinColumn(name = "book_type_id")
    private BookType bookType;

    @ManyToOne
    @JoinColumn(name = "book_condition_id")
    private BookCondition bookCondition;

    @JsonIgnore
    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private List<Offer> offers;

    public List<Work> getWorks() {
        return works;
    }

    public BookLanguage getBookLanguage() {
        return bookLanguage;
    }

    public BookType getBookType() {
        return bookType;
    }

    public BookCondition getBookCondition() {
        return bookCondition;
    }

    public List<Offer> getOffers() {
        return offers;
    }
}
