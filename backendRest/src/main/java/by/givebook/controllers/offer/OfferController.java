package by.givebook.controllers.offer;

import by.givebook.controllers.GenericController;
import by.givebook.controllers.SimpleController;
import by.givebook.dto.offer.OfferDTO;
import by.givebook.entities.offer.Book;
import by.givebook.entities.offer.Offer;
import by.givebook.services.SimpleService;
import by.givebook.services.offer.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

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

    //@Override
    @RequestMapping(value = "/new", method = RequestMethod.PUT)
    protected boolean addOrUpdate(@RequestBody OfferDTO offerDTO) {
        return service.save(service.transformDtoToEntity(offerDTO));
    }
}
