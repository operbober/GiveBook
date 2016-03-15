package by.givebook.services.impl.offer;

import by.givebook.entities.account.User;
import by.givebook.entities.library.Author;
import by.givebook.entities.library.Work;
import by.givebook.entities.offer.Book;
import by.givebook.entities.offer.Offer;
import by.givebook.entities.offer.OfferType;
import by.givebook.repositories.offer.OfferRepository;
import by.givebook.services.SimpleService;
import by.givebook.services.impl.SimpleServiceImpl;
import by.givebook.services.library.AuthorService;
import by.givebook.services.library.WorkService;
import by.givebook.services.offer.BookService;
import by.givebook.services.offer.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by FruityDevil on 05.03.2016.
 */
@Service
public class OfferServiceImpl extends SimpleServiceImpl<Offer, OfferRepository> implements OfferService {
    @Autowired
    BookService bookService;

    @Autowired
    @Qualifier("userService")
    SimpleService<User> userSimpleService;

    @Autowired
    @Qualifier("offerTypeService")
    SimpleService<OfferType> offerTypeSimpleService;

    @Override
    @Transactional
    public Offer save(Offer entity) {
        entity.setUser(userSimpleService.get(1L));
        entity.setOfferType(offerTypeSimpleService.get(1L));

        bookService.save(entity.getBook());
        return super.save(entity);
    }
}
