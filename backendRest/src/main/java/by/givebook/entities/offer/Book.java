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

    public Book() {
    }

    public Book(List<Work> works, BookLanguage bookLanguage, BookType bookType, BookCondition bookCondition) {
        this.works = works;
        this.bookLanguage = bookLanguage;
        this.bookType = bookType;
        this.bookCondition = bookCondition;
    }

    public List<Work> getWorks() {
        return works;
    }

    public void setWorks(List<Work> works) {
        this.works = works;
    }

    public BookLanguage getBookLanguage() {
        return bookLanguage;
    }

    public void setBookLanguage(BookLanguage bookLanguage) {
        this.bookLanguage = bookLanguage;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public BookCondition getBookCondition() {
        return bookCondition;
    }

    public void setBookCondition(BookCondition bookCondition) {
        this.bookCondition = bookCondition;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }
}
