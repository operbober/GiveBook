package by.givebook.controllers.offer;

import by.givebook.controllers.GenericController;
import by.givebook.entities.offer.Offer;
import by.givebook.services.offer.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @since 04.03.2016
 */
@RestController
@RequestMapping("/offers")
public class OfferController extends GenericController<Offer, OfferService> {

    @Autowired
    public OfferController(OfferService service) {
        super(service);
    }
}
