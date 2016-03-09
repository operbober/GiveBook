package by.givebook.controllers.offer;

import by.givebook.controllers.GenericController;
import by.givebook.entities.offer.OfferType;
import by.givebook.services.NamedService;
import by.givebook.services.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@RequestMapping("/offerTypes")
public class OfferTypeController extends GenericController<OfferType,SimpleService<OfferType>> {

    @Autowired
    public OfferTypeController(@Qualifier("offerTypeService") NamedService<OfferType> service) {
        super(service);
    }
}