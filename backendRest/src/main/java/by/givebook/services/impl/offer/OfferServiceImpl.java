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
import by.givebook.services.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by FruityDevil on 05.03.2016.
 */
@Service
public class OfferServiceImpl extends SimpleServiceImpl<Offer, OfferRepository> implements OfferService {
    @Autowired
    BookService bookService;

    @Autowired
    UserService userService;

    @Autowired
    @Qualifier("offerTypeService")
    SimpleService<OfferType> offerTypeSimpleService;

    @Override
    public void save(Offer entity) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        entity.setUser(userService.getUserByLogin(authentication.getName()));
        entity.setOfferType(offerTypeSimpleService.get(1L));

        bookService.save(entity.getBook());
        super.save(entity);
    }

    @Override
    public List<Offer> getMyOffers(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.getUserByLogin(authentication.getName());
        return repository.findByUser(currentUser);
    }
}
