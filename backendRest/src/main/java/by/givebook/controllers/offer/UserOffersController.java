package by.givebook.controllers.offer;

import by.givebook.entities.offer.Offer;
import by.givebook.services.offer.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @since 15.04.2016
 */
@RestController
@RequestMapping("/myOffers")
public class UserOffersController extends OfferController {

    @Autowired
    public UserOffersController(OfferService service) {
        super(service);
    }

    @Override
    protected List<Offer> get() {
        return service.getMyOffers();
    }

    @Override
    protected Offer getById(@PathVariable("id") Long id) {
        return super.getById(id);
    }
}
