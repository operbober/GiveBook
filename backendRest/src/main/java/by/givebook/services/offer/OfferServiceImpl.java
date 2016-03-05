package by.givebook.services.offer;

import by.givebook.dto.offer.OfferDTO;
import by.givebook.entities.account.User;
import by.givebook.entities.library.Work;
import by.givebook.entities.offer.Book;
import by.givebook.entities.offer.BookType;
import by.givebook.entities.offer.Offer;
import by.givebook.services.SimpleService;
import by.givebook.services.SimpleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by FruityDevil on 05.03.2016.
 */
@Service
public class OfferServiceImpl extends SimpleServiceImpl<Offer> implements OfferService {

    @Autowired
    private SimpleService<Work> workService;
    @Autowired
    private SimpleService<Book> bookService;
    @Autowired
    private SimpleService<User> userService;

    @Override
    public Offer transformDtoToEntity(OfferDTO offerDTO) {
        Offer offer = new Offer();
        offer.book = new Book();
        offer.book.work = workService.get(1L);
        offer.book.bookType = offerDTO.bookType;
        offer.book.bookCondition = offerDTO.bookCondition;
        offer.offerType = offerDTO.offerType;
        offer.user = userService.get(offerDTO.userId);
        return offer;
    }

    @Override
    public boolean save(Offer entity) {
        bookService.save(entity.book);
        return super.save(entity);
    }
}
