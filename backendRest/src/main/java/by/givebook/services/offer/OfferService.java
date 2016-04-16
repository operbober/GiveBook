package by.givebook.services.offer;

import by.givebook.entities.offer.Offer;
import by.givebook.services.SimpleService;

import java.util.List;

/**
 * Created by FruityDevil on 05.03.2016.
 */
public interface OfferService extends SimpleService<Offer> {
    List<Offer> getMyOffers();
}
