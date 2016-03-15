package by.givebook.dto.offer;

import by.givebook.entities.account.User;
import by.givebook.entities.offer.Book;
import by.givebook.entities.offer.Offer;
import by.givebook.entities.offer.OfferType;
import by.givebook.services.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @since 09.03.2016
 */
public class OfferDTO {
    private OfferType offerType;
    private BookDTO bookDTO;
    private User user;

    public OfferType getOfferType() {
        return offerType;
    }

    public BookDTO getBookDTO() {
        return bookDTO;
    }

    public User getUser() {
        return user;
    }

    public Offer toOffer(){
        Book book = bookDTO.toBook();
        return new Offer(book, user, offerType);
    }
}
