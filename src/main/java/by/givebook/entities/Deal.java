package by.givebook.entities;

import javax.persistence.*;

/**
 * Created by operb_000 on 14.10.2015.
 */
@Entity
@Table(name = "deals")
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "deal_type_id")
    private DealType dealType;

    public Deal(User user, Book book, DealType dealType) {
        this.user = user;
        this.book = book;
        this.dealType = dealType;
    }

    public Deal(User user, Book book, DealType dealType, String description) {
        this.user = user;
        this.book = book;
        this.dealType = dealType;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public DealType getDealType() {
        return dealType;
    }

    public void setDealType(DealType dealType) {
        this.dealType = dealType;
    }
}
