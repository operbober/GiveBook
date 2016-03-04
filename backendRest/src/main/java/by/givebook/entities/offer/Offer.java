package by.givebook.entities.offer;

import by.givebook.entities.account.User;
import by.givebook.entities.IdEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by operb_000 on 29.02.2016.
 */
@Entity
@Table(name = "offer")
public class Offer extends IdEntity {

    @ManyToOne
    @JoinColumn(name = "book_id")
    public Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

    @ManyToOne
    @JoinColumn(name = "offer_type_id")
    public OfferType offerType;
}
