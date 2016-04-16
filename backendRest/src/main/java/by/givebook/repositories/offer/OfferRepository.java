package by.givebook.repositories.offer;

import by.givebook.entities.account.User;
import by.givebook.entities.offer.Offer;
import by.givebook.repositories.SimpleRepository;

import java.util.List;

/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @since 04.03.2016
 */
public interface OfferRepository extends SimpleRepository<Offer> {
    List<Offer> findByUser(User user);
}
