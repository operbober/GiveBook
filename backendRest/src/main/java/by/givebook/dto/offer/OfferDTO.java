package by.givebook.dto.offer;

import by.givebook.entities.account.User;
import by.givebook.entities.offer.OfferType;

/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @since 09.03.2016
 */
public class OfferDTO {

    private OfferType offerType;
    private OfferBookDTO offerBookDTO;
    private User user;

    public OfferType getOfferType() {
        return offerType;
    }

    public OfferBookDTO getOfferBookDTO() {
        return offerBookDTO;
    }

    public User getUser() {
        return user;
    }
}
