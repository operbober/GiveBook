package by.givebook.controllers.offer;

import by.givebook.controllers.SimpleController;
import by.givebook.dto.OfferDTO;
import by.givebook.entities.offer.Book;
import by.givebook.entities.offer.Offer;
import by.givebook.services.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @since 04.03.2016
 */
@RestController
@RequestMapping("/offers")
public class OfferController extends SimpleController<Offer> {

    @Autowired
    public OfferController(@Qualifier("offerService") SimpleService<Offer> service) {
        super(service);
    }

    //@Override
    @RequestMapping(value = "/new", method = RequestMethod.PUT)
    protected boolean addOrUpdate(@RequestBody OfferDTO offer) {
        Offer newOffer = new Offer();
        newOffer.book = new Book();
        //newOffer.book.bookType = offer.bookType;
        //newOffer.book.bookCondition = offer.bookCondition;
        return false;
    }

}
