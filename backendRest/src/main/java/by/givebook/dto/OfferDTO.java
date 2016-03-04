package by.givebook.dto;

import by.givebook.entities.IdEntity;
import by.givebook.entities.offer.Book;
import by.givebook.entities.offer.BookCondition;
import by.givebook.entities.offer.BookType;
import by.givebook.entities.offer.OfferType;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @since 04.03.2016
 */
public class OfferDTO {
    public Long id;

    public String bookName;

    public BookType bookType;

//    public BookCondition bookCondition;

//    public OfferType offerType;

    public Long userId;
}
