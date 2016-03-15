package by.givebook.services.impl.offer;

import by.givebook.entities.library.Work;
import by.givebook.entities.offer.Book;
import by.givebook.repositories.offer.BookRepository;
import by.givebook.services.impl.SimpleServiceImpl;
import by.givebook.services.library.WorkService;
import by.givebook.services.offer.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;

/**
 * Created by operb_000 on 15.03.2016.
 */
@Service
public class BookServiceImpl extends SimpleServiceImpl<Book, BookRepository> implements BookService {

    @Autowired
    WorkService workService;

    @Override
    @Transactional
    public Book save(Book entity) {
        for (int i = 0; i < entity.getWorks().size(); i++){
            entity.getWorks().set(i, workService.save(entity.getWorks().get(i)));
        }

        return super.save(entity);
    }
}
