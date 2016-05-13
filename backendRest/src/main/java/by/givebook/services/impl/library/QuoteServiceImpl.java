package by.givebook.services.impl.library;

import by.givebook.entities.library.Quote;
import by.givebook.repositories.library.QuoteRepository;
import by.givebook.services.impl.SimpleServiceImpl;
import by.givebook.services.library.QuoteService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Random;


/**
 * Created by operb_000 on 13.05.2016.
 */
@Service
public class QuoteServiceImpl extends SimpleServiceImpl<Quote, QuoteRepository> implements QuoteService{

    @Override
    public Quote getRandom() {
        Random random = new Random();
        return repository.findAll(new PageRequest(random.nextInt((int) repository.count()), 1)).getContent().get(0);
    }
}
